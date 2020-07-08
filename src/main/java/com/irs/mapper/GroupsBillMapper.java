package com.irs.mapper;

import com.irs.pojo.GroupsBill;
import com.irs.pojo.GroupsBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupsBillMapper {
    long countByExample(GroupsBillExample example);

    int deleteByExample(GroupsBillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GroupsBill record);

    int insertSelective(GroupsBill record);

    List<GroupsBill> selectByExample(GroupsBillExample example);

    GroupsBill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GroupsBill record, @Param("example") GroupsBillExample example);

    int updateByExample(@Param("record") GroupsBill record, @Param("example") GroupsBillExample example);

    int updateByPrimaryKeySelective(GroupsBill record);

    int updateByPrimaryKey(GroupsBill record);
}