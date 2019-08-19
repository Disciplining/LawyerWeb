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
}