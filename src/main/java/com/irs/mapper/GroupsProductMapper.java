package com.irs.mapper;

import com.irs.pojo.GroupsProduct;
import com.irs.pojo.GroupsProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupsProductMapper {
    long countByExample(GroupsProductExample example);

    int deleteByExample(GroupsProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GroupsProduct record);

    int insertSelective(GroupsProduct record);

    List<GroupsProduct> selectByExample(GroupsProductExample example);

    GroupsProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GroupsProduct record, @Param("example") GroupsProductExample example);

    int updateByExample(@Param("record") GroupsProduct record, @Param("example") GroupsProductExample example);

    int updateByPrimaryKeySelective(GroupsProduct record);

    int updateByPrimaryKey(GroupsProduct record);
}