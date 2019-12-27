package com.seckill.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/to_list")
    public String toIndex() {
        return "goods_list";
    }

}
