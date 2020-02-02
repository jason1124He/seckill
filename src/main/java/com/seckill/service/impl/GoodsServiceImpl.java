package com.seckill.service.impl;

import com.seckill.entity.GoodsEntity;
import com.seckill.dao.GoodsDao;
import com.seckill.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hej
 * @since 2019-12-27
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<GoodsVO> listGoodsVo() {
        List<GoodsVO> goodsVOS = goodsDao.listGoodsVo();
        return goodsVOS;
    }

    @Override
    public GoodsVO getGoodsVoByGoodsId(long goodsId) {
        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }
}
