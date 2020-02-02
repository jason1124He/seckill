package com.seckill.service;

import com.seckill.entity.GoodsEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.vo.GoodsVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hej
 * @since 2019-12-27
 */
public interface GoodsService extends IService<GoodsEntity> {
    /**
     * 获取商品列表
     * @return
     */
    List<GoodsVO> listGoodsVo();

    GoodsVO getGoodsVoByGoodsId(long goodsId);
}
