package com.seckill.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.seckill.entity.SeckillUserEntity;
import com.seckill.service.SeckillUserService;
import com.seckill.service.UserService;
import com.seckill.service.impl.SeckillUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hej
 * @since 2019-12-27
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private SeckillUserService userService;

    /*@RequestMapping(value = "/to_list")
    public String toIndex(HttpServletRequest request, HttpServletResponse response, Model model,
                          @CookieValue(value = SeckillUserServiceImpl.COOKEN_NAME_TOKEN, required = false) String cookieToken
            , @RequestParam(value = SeckillUserServiceImpl.COOKEN_NAME_TOKEN, required = false) String reqToken) {

        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(reqToken)) {
            return "login";
        }
        String token = StringUtils.isEmpty(cookieToken) ? reqToken : cookieToken;

        SeckillUserEntity user = userService.getByToken(token, response);

        if (null != user) {
            model.addAttribute("user", user);
        }
        return "goods_list";
    }*/
    @RequestMapping(value = "/to_list")
    public String toIndex(Model model, SeckillUserEntity user) {
        if (null != user) {
            model.addAttribute("user", user);
        }
        return "goods_list";
    }

}
