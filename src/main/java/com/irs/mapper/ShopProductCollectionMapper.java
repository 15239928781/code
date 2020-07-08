package com.irs.mapper;

import java.util.List;

import com.irs.pojo.ShopProductCollection;
import com.irs.pojo.ShopProductCollectionExample;
import org.apache.ibatis.annotations.Param;

public interface ShopProductCollectionMapper {
    int countByExample(ShopProductCollectionExample example);

    int deleteByExample(ShopProductCollectionExample example);

    int deleteByPrimaryKey(Integer pcId);

    int insert(ShopProductCollection record);

    int insertSelective(ShopProductCollection record);

    List<ShopProductCollection> selectByExample(ShopProductCollectionExample example);

    ShopProductCollection selectByPrimaryKey(Integer pcId);

    int updateByExampleSelective(@Param("record") ShopProductCollection record, @Param("example") ShopProductCollectionExample example);

    int updateByExample(@Param("record") ShopProductCollection record, @Param("example") ShopProductCollectionExample example);

    int updateByPrimaryKeySelective(ShopProductCollection record);

    int updateByPrimaryKey(ShopProductCollection record);

	List<ShopProductCollection> getItemList(ShopProductCollection shopProductCollection);

	int countByShopProductCollection();
}