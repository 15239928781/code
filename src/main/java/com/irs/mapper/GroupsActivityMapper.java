package com.irs.mapper;

import com.irs.pojo.GroupsActivity;
import com.irs.pojo.GroupsActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupsActivityMapper {
    long countByExample(GroupsActivityExample example);

    int deleteByExample(GroupsActivityExample example);

    int deleteByPrimaryKey(Integer aId);

    int insert(GroupsActivity record);

    int insertSelective(GroupsActivity record);

    List<GroupsActivity> selectByExample(GroupsActivityExample example);

    GroupsActivity selectByPrimaryKey(Integer aId);

    int updateByExampleSelective(@Param("record") GroupsActivity record, @Param("example") GroupsActivityExample example);

    int updateByExample(@Param("record") GroupsActivity record, @Param("example") GroupsActivityExample example);

    int updateByPrimaryKeySelective(GroupsActivity record);

    int updateByPrimaryKey(GroupsActivity record);
}