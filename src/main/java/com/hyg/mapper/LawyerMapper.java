package com.hyg.mapper;

import com.hyg.pojo.Lawyer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 律师
 */
@Mapper
@Repository("lawyerMapper")
public interface LawyerMapper {
    @Select("select * from t_lawyer WHERE deleteFlag='0'")
    public List<Lawyer> findAllLawyer();

}
