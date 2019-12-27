package com.seckill.controller;


import com.seckill.common.AccessKey;
import com.seckill.utils.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/index")
    public String toIndex() {
        redisService.set( AccessKey.withExpire(10),"1","2");
        return "index";
    }

    @RequestMapping(value = "/common/{path}")
    public String common(@PathVariable String path) {
        return path;
    }
}
