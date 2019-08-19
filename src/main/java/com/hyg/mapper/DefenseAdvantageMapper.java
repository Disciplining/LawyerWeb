package com.hyg.mapper;

import com.hyg.pojo.DefenseAdvantage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("defenseAdvantageMapper")
public interface DefenseAdvantageMapper
{
    /**
     * 获得所有数据
     * @return
     */
    @Select(" select * from `t_defenseAdvantage` where `deleteFlag`!='1' ")
    List<DefenseAdvantage> listAllData();
}