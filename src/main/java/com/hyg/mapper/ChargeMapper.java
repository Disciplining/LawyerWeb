package com.hyg.mapper;

import com.hyg.pojo.Charge;
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
	// 查
	/**
	 * 输入：罪名分类的id
	 * 输出：这个罪名分类下的所有罪名名称
	 * @return
	 */
	@Select(" select `chargeName` from `t_charge` where `chargeTypeId`=#{chargeTypeId} and `deleteFlag`!='1' ")
	List<String> listChargeNameByChargeTypeId(int chargeTypeId);

	/**
	 * 输入：罪名分类的名称
	 * 输出：这个罪名分类下的所有罪名名称
	 * @param name
	 * @return
	 */
	@Select(" select `t_charge`.`chargeName` from `t_charge`" +
				" where `t_charge`.`chargeTypeId`=" +
					" (select `t_chargeType`.`id` from `t_chargeType` where `t_chargeType`.chargeTypeName=#{name}); ")
	List<String> listAllChargeNameByChargeTypeName(String name);

	/**
	 * 输入：罪名分类的名称
	 * 输出：这个罪名分类下的所有罪名实体
	 * @param name
	 * @return
	 */
	@Select(" select * from `t_charge`" +
				" where `t_charge`.`chargeTypeId`=" +
				" (select `t_chargeType`.`id` from `t_chargeType` where `t_chargeType`.chargeTypeName=#{name}); ")
	List<Charge> listChargeByChargeTypeName(String name);
	//--------------------------------------------------------------------------------------------------------------------
}