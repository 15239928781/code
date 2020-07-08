package com.irs.mapper;

import com.irs.pojo.IntegralUse;
import com.irs.pojo.IntegralUseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntegralUseMapper {
    long countByExample(IntegralUseExample example);

    int deleteByExample(IntegralUseExample example);

    int deleteByPrimaryKey(Integer iuId);

    int insert(IntegralUse record);

    int insertSelective(IntegralUse record);

    List<IntegralUse> selectByExample(IntegralUseExample example);

    IntegralUse selectByPrimaryKey(Integer iuId);

    int updateByExampleSelective(@Param("record") IntegralUse record, @Param("example") IntegralUseExample example);

    int updateByExample(@Param("record") IntegralUse record, @Param("example") IntegralUseExample example);

    int updateByPrimaryKeySelective(IntegralUse record);

    int updateByPrimaryKey(IntegralUse record);
}