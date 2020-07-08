package com.irs.mapper;

import com.irs.pojo.ShopOrders;
import com.irs.pojo.ShopOrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopOrdersMapper {
    long countByExample(ShopOrdersExample example);

    int deleteByExample(ShopOrdersExample example);

    int deleteByPrimaryKey(Integer oId);

    int insert(ShopOrders record);

    int insertSelective(ShopOrders record);

    List<ShopOrders> selectByExample(ShopOrdersExample example);

    ShopOrders selectByPrimaryKey(Integer oId);

    int updateByExampleSelective(@Param("record") ShopOrders record, @Param("example") ShopOrdersExample example);

    int updateByExample(@Param("record") ShopOrders record, @Param("example") ShopOrdersExample example);

    int updateByPrimaryKeySelective(ShopOrders record);

    int updateByPrimaryKey(ShopOrders record);

    //获取累计总收入
    Double sumTotal();

    //获取当天的收入
    Double Today(@Param("todaytime") String todaytime);

    //获取每个月的收入
    List<ShopOrders> getTalbymoth(@Param("ordertime") String ordertime);

    //获取每个月的订单总数
    List<ShopOrders> getorderbymoth(@Param("ordertime") String ordertime);

    Double sumTotalByTime(@Param("createTimeStart")String createTimeStart, @Param("createTimeEnd")String createTimeEnd);


}