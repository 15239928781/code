package com.irs.mapper;

import com.irs.pojo.ShopOrderitem;
import com.irs.pojo.ShopOrderitemExample;
import java.util.List;

import com.irs.pojo.ShopOrders;
import org.apache.ibatis.annotations.Param;

public interface ShopOrderitemMapper {
    long countByExample(ShopOrderitemExample example);

    int deleteByExample(ShopOrderitemExample example);

    int deleteByPrimaryKey(Integer oiId);

    int insert(ShopOrderitem record);

    int insertSelective(ShopOrderitem record);

    List<ShopOrderitem> selectByExample(ShopOrderitemExample example);

    ShopOrderitem selectByPrimaryKey(Integer oiId);

    int updateByExampleSelective(@Param("record") ShopOrderitem record, @Param("example") ShopOrderitemExample example);

    int updateByExample(@Param("record") ShopOrderitem record, @Param("example") ShopOrderitemExample example);

    int updateByPrimaryKeySelective(ShopOrderitem record);

    int updateByPrimaryKey(ShopOrderitem record);

    List<ShopOrderitem> getItemList(int oId);

    List<ShopOrderitem> rankList();

    List<ShopOrderitem> getAll(@Param("time")String time);

    List<ShopOrderitem> getAll2();
}