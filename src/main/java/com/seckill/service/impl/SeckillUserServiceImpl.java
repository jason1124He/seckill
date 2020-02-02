package com.seckill.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.seckill.config.redis.SeckillUserKey;
import com.seckill.entity.SeckillUserEntity;
import com.seckill.dao.SeckillUserDao;
import com.seckill.exception.GlobalException;
import com.seckill.result.CodeMsg;
import com.seckill.service.SeckillUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.utils.UUIDUtil;
import com.seckill.utils.redis.RedisService;
import com.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hej
 * @since 2019-12-27
 */
@Service
public class SeckillUserServiceImpl extends ServiceImpl<SeckillUserDao, SeckillUserEntity> implements SeckillUserService {

    public static final String COOKEN_NAME_TOKEN = "token";

    @Autowired
    private RedisService redisService;

    /* @Override
     public String login(HttpServletResponse response, LoginVo loginVo) {
         String msg = ServiceConstant.SUCCESS_MSG;
 //        if (StringUtils.isEmpty(loginVo.getMobile())) {
 //            msg = ServiceConstant.NULL_PHONE;
 //        }
 //        if (StringUtils.isEmpty(loginVo.getPassword())) {
 //            msg = ServiceConstant.NULL_PASSWORD;
 //        }
 //        if (StringUtils.isNotEmpty(loginVo.getMobile()) && StringUtils.isNotEmpty(loginVo.getPassword())) {
         if (null != loginVo) {
             SeckillUserEntity user = getById(loginVo.getMobile());
             if (null == user) {
                 msg = ServiceConstant.NOT_EXIST_PHONE;
             }
             if (null != user) {
                 if (!user.getPassword().equals(loginVo.getPassword())) {
                     msg = ServiceConstant.ERROR_PASSWORD;
                 }
             }
         }
         return msg;
     }*/
    @Override
    public boolean login(HttpServletResponse response, LoginVo loginVo) {

        if (null == loginVo) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        if (null != loginVo) {
            SeckillUserEntity user = getById(loginVo.getMobile());
            if (null == user) {
                throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
            }
            if (null != user) {

                if (!user.getPassword().equals(loginVo.getPassword())) {
                    throw new GlobalException(CodeMsg.PASSWORD_ERROR);
                }
            }

            String token = UUIDUtil.uuid();
            addCookie(user, response, token);
        }


        return true;
    }

    @Override
    public SeckillUserEntity getByToken(String token, HttpServletResponse response) {

        if (StringUtils.isNotEmpty(token)) {

            SeckillUserEntity user = redisService.get(SeckillUserKey.token, token, SeckillUserEntity.class);
            //延长cookie有效期
            addCookie(user, response, token);
            return user;
        }
        return null;
    }

    /**
     * 保存cookie
     * 无须每次生成新token,只需要每次更新之前token的有效期就行
     *
     * @param user
     * @param response
     * @param token
     */
    private void addCookie(SeckillUserEntity user, HttpServletResponse response, String token) {

        //实现session同步登录状态
        //浏览器端对应生成cookie
        //session写入到redis中
        redisService.set(SeckillUserKey.token, token, user);
        Cookie cookie = new Cookie(COOKEN_NAME_TOKEN, token);
        //cookie 的生存时间与 session生存时间一致
        cookie.setMaxAge(SeckillUserKey.token.expireSeconds());
        //cookie的保存路径
        cookie.setPath("/");
        response.addCookie(cookie);

    }
}
