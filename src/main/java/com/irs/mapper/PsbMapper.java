package com.irs.mapper;

import com.irs.pojo.Level;
import com.irs.pojo.Psb;
import com.irs.pojo.PsbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsbMapper {
    long countByExample(PsbExample example);

    int deleteByExample(PsbExample example);

    List<Psb> selectByPrimaryKey(Integer pId);

    int insert(Psb record);

    int insertSelective(Psb record);

    List<Psb> selectByExample(PsbExample example);

    int updateByExampleSelective(@Param("record") Psb record, @Param("example") PsbExample example);

    int updateByExample(@Param("record") Psb record, @Param("example") PsbExample example);
}