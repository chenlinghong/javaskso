package com.chenlinghong.javaskso.dao;

import com.chenlinghong.javaskso.domain.Goods;
import com.chenlinghong.javaskso.domain.SeckillGoods;
import com.chenlinghong.javaskso.vo.GoodsVo;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/10
 * Time: 22:16
 */
@Mapper
public interface IGoodsDao {

    @Select("Select g.*,sg.stock_count,sg.start_date,sg.end_date,sg.seckill_price from seckill_goods sg left join goods g on sg.goods_id=g.id")
    List<GoodsVo> listGoodsVo();

    @Select("Select g.*,sg.stock_count,sg.start_date,sg.end_date,sg.seckill_price from seckill_goods sg left join goods g on sg.goods_id=g.id where g.id=#{goodsId}")
    GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

    @Update("update seckill_goods set stock_count=stock_count-1 where goods_id=#{goodsId}")
    int reduceStock(SeckillGoods seckillGoods);
}
