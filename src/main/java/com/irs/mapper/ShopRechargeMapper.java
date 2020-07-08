package com.irs.mapper;

import com.irs.pojo.ShopRecharge;
import com.irs.pojo.ShopRechargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopRechargeMapper {
    int countByExample(ShopRechargeExample example);

    int deleteByExample(ShopRechargeExample example);

    int deleteByPrimaryKey(Integer rId);

    int insert(ShopRecharge record);

    int insertSelective(ShopRecharge record);

    List<ShopRecharge> selectByExample(ShopRechargeExample example);

    ShopRecharge selectByPrimaryKey(Integer rId);

    int updateByExampleSelective(@Param("record") ShopRecharge record, @Param("example") ShopRechargeExample example);

    int updateByExample(@Param("record") ShopRecharge record, @Param("example") ShopRechargeExample example);

    int updateByPrimaryKeySelective(ShopRecharge record);

    int updateByPrimaryKey(ShopRecharge record);
}