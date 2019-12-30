package com.seckill.service;

import com.seckill.entity.SeckillUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hej
 * @since 2019-12-27
 */
public interface SeckillUserService extends IService<SeckillUserEntity> {

    boolean login(HttpServletResponse response, LoginVo loginVo);

    SeckillUserEntity getByToken(String token, HttpServletResponse response);
}
