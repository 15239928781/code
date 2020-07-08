package com.irs.mapper;

import com.irs.pojo.ShopProduct;
import com.irs.pojo.ShopProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopProductMapper {
    long countByExample(ShopProductExample example);

    int deleteByExample(ShopProductExample example);

    int deleteByPrimaryKey(Integer pId);

    int insert(ShopProduct record);

    int insertSelective(ShopProduct record);

    List<ShopProduct> selectByExample(ShopProductExample example);

    ShopProduct selectByPrimaryKey(Integer pId);

    int updateByExampleSelective(@Param("record") ShopProduct record, @Param("example") ShopProductExample example);

    int updateByExample(@Param("record") ShopProduct record, @Param("example") ShopProductExample example);

    int updateByPrimaryKeySelective(ShopProduct record);

    int updateByPrimaryKey(ShopProduct record);

    List<ShopProduct> getProductByUid(@Param("uid") int uid);

    List<ShopProduct> getProductByNum();
    List<ShopProduct> getProductByPid();

    List<ShopProduct> getBrowse(int id);

    //查询素材排行的前5条数据
    List<ShopProduct> getpropaihang();

    List<ShopProduct> getTeacher();

    ShopProduct selectbyPid(@Param("pId") int pId);
}