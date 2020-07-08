package com.irs.mapper;

import com.irs.pojo.Subarea;
import com.irs.pojo.SubareaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubareaMapper {
    long countByExample(SubareaExample example);

    int deleteByExample(SubareaExample example);

    int deleteByPrimaryKey(Long sbId);

    int insert(Subarea record);

    int insertSelective(Subarea record);

    List<Subarea> selectByExample(SubareaExample example);

    Subarea selectByPrimaryKey(Long sbId);

    int updateByExampleSelective(@Param("record") Subarea record, @Param("example") SubareaExample example);

    int updateByExample(@Param("record") Subarea record, @Param("example") SubareaExample example);

    int updateByPrimaryKeySelective(Subarea record);

    int updateByPrimaryKey(Subarea record);
}