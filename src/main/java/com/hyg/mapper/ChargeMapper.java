package com.hyg.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 罪名表 mapper
 */
@Mapper
@Repository("chargeMapper")
public interface ChargeMapper
{
	/**
	 * 获得 某个罪名分类id 下的 所有罪名
	 * @return
	 */
	@Select(" select `chargeName` from `t_charge` where `chargeTypeId`=#{chargeTypeId} and `deleteFlag`!='1' ")
	List<String> listChargeNameByChargeTypeId(int chargeTypeId);

	/**
	 * 根据罪名分类名称  获得这个罪名分类下的所有罪名的名称
	 * @param name
	 * @return
	 */
	@Select(" select `t_charge`.`chargeName` from `t_charge`" +
				" where `t_charge`.`chargeTypeId`=" +
					" (select `t_chargeType`.`id` from `t_chargeType` where `t_chargeType`.chargeTypeName=#{name}); ")
	List<String> listAllChargeNameByChargeTypeName(String name);
}