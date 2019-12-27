package com.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seckill.common.ServiceConstant;
import com.seckill.entity.SeckillUserEntity;
import com.seckill.dao.SeckillUserDao;
import com.seckill.service.SeckillUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

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

    @Override
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
    }
}
