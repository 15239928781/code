package com.irs.mapper;

import com.irs.pojo.ShopBrowse;
import com.irs.pojo.ShopBrowseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopBrowseMapper {
    long countByExample(ShopBrowseExample example);

    int deleteByExample(ShopBrowseExample example);

    int deleteByPrimaryKey(Integer bId);

    int insert(ShopBrowse record);

    int insertSelective(ShopBrowse record);

    List<ShopBrowse> selectByExample(ShopBrowseExample example);

    ShopBrowse selectByPrimaryKey(Integer bId);

    int updateByExampleSelective(@Param("record") ShopBrowse record, @Param("example") ShopBrowseExample example);

    int updateByExample(@Param("record") ShopBrowse record, @Param("example") ShopBrowseExample example);

    int updateByPrimaryKeySelective(ShopBrowse record);

    int updateByPrimaryKey(ShopBrowse record);

    List<ShopBrowse> selectByExample2(ShopBrowseExample example);

    List<ShopBrowse> getAll(@Param("btype")String  btype);

    List<ShopBrowse> getAll2();
}