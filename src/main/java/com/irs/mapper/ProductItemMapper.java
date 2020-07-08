package com.irs.mapper;

import com.irs.pojo.ProductItem;
import com.irs.pojo.ProductItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductItemMapper {
    long countByExample(ProductItemExample example);

    int deleteByExample(ProductItemExample example);

    int deleteByPrimaryKey(Integer iId);

    int insert(ProductItem record);

    int insertSelective(ProductItem record);

    List<ProductItem> selectByExample(ProductItemExample example);

    ProductItem selectByPrimaryKey(Integer iId);

    int updateByExampleSelective(@Param("record") ProductItem record, @Param("example") ProductItemExample example);

    int updateByExample(@Param("record") ProductItem record, @Param("example") ProductItemExample example);

    int updateByPrimaryKeySelective(ProductItem record);

    int updateByPrimaryKey(ProductItem record);

    ProductItem selectByiPic(@Param("fileName2")String fileName2);
}