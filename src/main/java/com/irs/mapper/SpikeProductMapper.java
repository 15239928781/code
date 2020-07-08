package com.irs.mapper;

import com.irs.pojo.SpikeProduct;
import com.irs.pojo.SpikeProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpikeProductMapper {
    long countByExample(SpikeProductExample example);

    int deleteByExample(SpikeProductExample example);

    int deleteByPrimaryKey(Integer spId);

    int insert(SpikeProduct record);

    int insertSelective(SpikeProduct record);

    List<SpikeProduct> selectByExample(SpikeProductExample example);

    SpikeProduct selectByPrimaryKey(Integer spId);

    int updateByExampleSelective(@Param("record") SpikeProduct record, @Param("example") SpikeProductExample example);

    int updateByExample(@Param("record") SpikeProduct record, @Param("example") SpikeProductExample example);

    int updateByPrimaryKeySelective(SpikeProduct record);

    int updateByPrimaryKey(SpikeProduct record);
}