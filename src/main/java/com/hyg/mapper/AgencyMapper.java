package com.hyg.mapper;


import com.hyg.pojo.Agency;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 事务所
 */
@Mapper
@Repository("agencyMapper")
public interface AgencyMapper
{
    /**
     * 查询事务所介绍
     */
    @Select("select * from t_agency")
    List<Agency> findAgency();
}