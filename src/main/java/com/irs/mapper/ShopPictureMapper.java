package com.irs.mapper;

import com.irs.pojo.ShopPicture;
import com.irs.pojo.ShopPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopPictureMapper {
    long countByExample(ShopPictureExample example);

    int deleteByExample(ShopPictureExample example);

    int deleteByPrimaryKey(Integer spId);

    int insert(ShopPicture record);

    int insertSelective(ShopPicture record);

    List<ShopPicture> selectByExample(ShopPictureExample example);

    ShopPicture selectByPrimaryKey(Integer spId);

    int updateByExampleSelective(@Param("record") ShopPicture record, @Param("example") ShopPictureExample example);

    int updateByExample(@Param("record") ShopPicture record, @Param("example") ShopPictureExample example);

    int updateByPrimaryKeySelective(ShopPicture record);

    int updateByPrimaryKey(ShopPicture record);

    void insertForeach(@Param("pictureList")List<ShopPicture> pictureList);
}