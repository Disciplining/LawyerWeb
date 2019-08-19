package com.hyg.mapper;

import com.hyg.pojo.ChargeType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("chargeTypeMapper")
public interface ChargeTypeMapper
{
	/**
	 * 获得所有罪名分类的名称
	 * @return
	 */
	@Select(" select `chargeTypeName` from `t_chargeType` where `deleteFlag`!='1' ")
	List<String> listChargeTypeName();

	/**
	 * 根据 罪名分类名称 获得 一个罪名分类
	 * @param name
	 * @return
	 */
	@Select(" select * from `t_chargeType` where `deleteFlag`!='1' and `chargeTypeName`=#{name} ")
	ChargeType getOneChargeTypeByName(String name);
}
