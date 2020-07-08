package com.irs.mapper;

import com.irs.pojo.Svl;
import com.irs.pojo.SvlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SvlMapper {
    long countByExample(SvlExample example);

    int deleteByExample(SvlExample example);

    int insert(Svl record);

    int insertSelective(Svl record);

    List<Svl> selectByExample(SvlExample example);

    int updateByExampleSelective(@Param("record") Svl record, @Param("example") SvlExample example);

    int updateByExample(@Param("record") Svl record, @Param("example") SvlExample example);
}