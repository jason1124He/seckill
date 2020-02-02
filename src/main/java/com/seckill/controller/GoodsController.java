package com.seckill.controller;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.seckill.entity.SeckillUserEntity;
import com.seckill.service.GoodsService;
import com.seckill.service.SeckillGoodsService;
import com.seckill.service.SeckillUserService;
import com.seckill.service.UserService;
import com.seckill.service.impl.SeckillUserServiceImpl;
import com.seckill.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @Autowired
    private GoodsService goodsService;

/*
    @RequestMapping(value = "/to_list")
    public String toIndex(Model model, SeckillUserEntity user) {
        if (null != user) {
            model.addAttribute("user", user);
        }
        return "goods_list";
    }*/

    @RequestMapping(value = "/to_list")
    public String listGoods(Model model, SeckillUserEntity user) {
        if (null != user) {
            model.addAttribute("user", user);
        }
        List<GoodsVO> list = goodsService.listGoodsVo();
        if (CollectionUtils.isNotEmpty(list)) {
            model.addAttribute("goodsList", list);
        }
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String detail(Model model,SeckillUserEntity user,
                         @PathVariable("goodsId")long goodsId) {
        model.addAttribute("user", user);

        GoodsVO goods = goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goods);

        long startAt = goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int miaoshaStatus = 0;
        int remainSeconds = 0;
        if(now < startAt ) {//秒杀还没开始，倒计时
            miaoshaStatus = 0;
            remainSeconds = (int)((startAt - now )/1000);
        }else  if(now > endAt){//秒杀已经结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        }else {//秒杀进行中
            miaoshaStatus = 1;
            remainSeconds = 0;

        }
        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        return "goods_detail";
    }

}
