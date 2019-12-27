package com.seckill.controller;


import com.seckill.common.AccessKey;
import com.seckill.result.Result;
import com.seckill.service.SeckillUserService;
import com.seckill.utils.redis.RedisService;
import com.seckill.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class PageController {

    private static Logger log = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/index")
    public String toIndex() {
//        redisService.set( AccessKey.withExpire(10),"1","2");
        return "index";
    }

    @RequestMapping(value = "/common/{path}")
    public String common(@PathVariable String path) {
        return path;
    }
}
