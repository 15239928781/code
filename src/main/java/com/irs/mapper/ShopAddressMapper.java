package com.irs.mapper;

import com.irs.pojo.ShopAddress;
import com.irs.pojo.ShopAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopAddressMapper {
    long countByExample(ShopAddressExample example);

    int deleteByExample(ShopAddressExample example);

    int deleteByPrimaryKey(Integer aId);

    int insert(ShopAddress record);

    int insertSelective(ShopAddress record);

    List<ShopAddress> selectByExample(ShopAddressExample example);

    ShopAddress selectByPrimaryKey(Integer aId);

    int updateByExampleSelective(@Param("record") ShopAddress record, @Param("example") ShopAddressExample example);

    int updateByExample(@Param("record") ShopAddress record, @Param("example") ShopAddressExample example);

    int updateByPrimaryKeySelective(ShopAddress record);

    int updateByPrimaryKey(ShopAddress record);

    ShopAddress getFirstAddress(int uId);
}