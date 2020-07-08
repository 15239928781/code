package com.irs.mapper;

import com.irs.pojo.ShopRollpic;
import com.irs.pojo.ShopRollpicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopRollpicMapper {
    long countByExample(ShopRollpicExample example);

    int deleteByExample(ShopRollpicExample example);

    int deleteByPrimaryKey(Integer rId);

    int insert(ShopRollpic record);

    int insertSelective(ShopRollpic record);

    List<ShopRollpic> selectByExample(ShopRollpicExample example);

    ShopRollpic selectByPrimaryKey(Integer rId);

    int updateByExampleSelective(@Param("record") ShopRollpic record, @Param("example") ShopRollpicExample example);

    int updateByExample(@Param("record") ShopRollpic record, @Param("example") ShopRollpicExample example);

    int updateByPrimaryKeySelective(ShopRollpic record);

    int updateByPrimaryKey(ShopRollpic record);

    ShopRollpic selectByType(int type);
}