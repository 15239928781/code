package com.irs.mapper;

import com.irs.pojo.TdCode;
import com.irs.pojo.TdCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TdCodeMapper {
    long countByExample(TdCodeExample example);

    int deleteByExample(TdCodeExample example);

    int deleteByPrimaryKey(Integer tdId);

    int insert(TdCode record);

    int insertSelective(TdCode record);

    List<TdCode> selectByExample(TdCodeExample example);

    TdCode selectByPrimaryKey(Integer tdId);

    int updateByExampleSelective(@Param("record") TdCode record, @Param("example") TdCodeExample example);

    int updateByExample(@Param("record") TdCode record, @Param("example") TdCodeExample example);

    int updateByPrimaryKeySelective(TdCode record);

    int updateByPrimaryKey(TdCode record);
}