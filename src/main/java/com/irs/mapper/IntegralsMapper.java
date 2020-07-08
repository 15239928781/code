package com.irs.mapper;

import com.irs.pojo.Integrals;
import com.irs.pojo.IntegralsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegralsMapper {
    long countByExample(IntegralsExample example);

    int deleteByExample(IntegralsExample example);

    int deleteByPrimaryKey(Integer iId);

    int insert(Integrals record);

    int insertSelective(Integrals record);

    List<Integrals> selectByExample(IntegralsExample example);

    Integrals selectByPrimaryKey(Integer iId);

    int updateByExampleSelective(@Param("record") Integrals record, @Param("example") IntegralsExample example);

    int updateByExample(@Param("record") Integrals record, @Param("example") IntegralsExample example);

    int updateByPrimaryKeySelective(Integrals record);

    int updateByPrimaryKey(Integrals record);


    int sumIntegral(@Param("type")Integer type, @Param("uId") Integer uId);
}