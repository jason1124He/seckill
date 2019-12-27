package com.seckill.controller;

import com.seckill.common.ServiceConstant;
import com.seckill.result.CodeMsg;
import com.seckill.result.Result;
import com.seckill.service.SeckillUserService;
import com.seckill.vo.LoginVo;
import jdk.nashorn.internal.ir.ReturnNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SeckillUserService userService;

    @RequestMapping(value = "/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/do_login", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Validated LoginVo loginVo) {
        log.info(loginVo.toString());
        //登录
        String msg = userService.login(response, loginVo);
        if (ServiceConstant.NULL_PASSWORD.equals(msg)) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if (ServiceConstant.NULL_PHONE.equals(msg)) {
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }
        if (ServiceConstant.NOT_EXIST_PHONE.equals(msg)) {
            return Result.error(CodeMsg.MOBILE_NOT_EXIST);
        }
        if (ServiceConstant.ERROR_PASSWORD.equals(msg)) {
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        return Result.success(true);
    }
}
