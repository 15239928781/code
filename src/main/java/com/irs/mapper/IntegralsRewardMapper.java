package com.irs.mapper;

import com.irs.pojo.IntegralsReward;
import com.irs.pojo.IntegralsRewardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntegralsRewardMapper {
    long countByExample(IntegralsRewardExample example);

    int deleteByExample(IntegralsRewardExample example);

    int deleteByPrimaryKey(Integer rId);

    int insert(IntegralsReward record);

    int insertSelective(IntegralsReward record);

    List<IntegralsReward> selectByExample(IntegralsRewardExample example);

    IntegralsReward selectByPrimaryKey(Integer rId);

    int updateByExampleSelective(@Param("record") IntegralsReward record, @Param("example") IntegralsRewardExample example);

    int updateByExample(@Param("record") IntegralsReward record, @Param("example") IntegralsRewardExample example);

    int updateByPrimaryKeySelective(IntegralsReward record);

    int updateByPrimaryKey(IntegralsReward record);
}