package com.seckill.dao;

import com.seckill.entity.GoodsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seckill.entity.SeckillGoodsEntity;
import com.seckill.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hej
 * @since 2019-12-27
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {

    @Select("select g.* ,sg.* from goods g LEFT JOIN seckill_goods  sg on sg.goods_id = g.id")
    List<GoodsVO> listGoodsVo();

    @Select("SELECT g.*, mg.stock_count,mg.start_date,  mg.end_date,  mg.seckill_price  FROM   seckill_goods mg  LEFT JOIN goods g ON mg.goods_id = g.id  where g.id = #{goodsId}")
    GoodsVO getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

    @Update("update seckill_goods set stock_count = stock_count - 1 where goods_id = #{goodsId}")
    public int reduceStock(SeckillGoodsEntity g);
}
