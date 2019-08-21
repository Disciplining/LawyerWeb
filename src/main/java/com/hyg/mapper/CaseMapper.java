package com.hyg.mapper;


import com.hyg.pojo.Case;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("caseMapper")
public interface CaseMapper
{
	/**
	 * 获得某个罪名名称下的所有案例
	 * @param chargeName
	 * @return
	 */
	@Select(" select * from `t_case` " +
				" where `chargeId`=(select `id` from `t_charge` where `chargeName`=#{chargeName}) ")
	List<Case> getAllCaseByChargeName(String chargeName);

	/**
	 * 根据 一个案例的id
	 * 获得这个 案例的罪名名称  和  罪名分类名称
	 * @param id
	 * @return chargeTypeName chargeName 分别是对应的key
	 */
	@Select(" select `t_chargeType`.`chargeTypeName`, `t_charge`.`chargeName` " +
				" from `t_chargeType` cross join `t_charge` on  `t_charge`.`id`=#{id} and `t_chargeType`.`id` = `t_charge`.`chargeTypeId` ")
	Map<String, String> getChargenameAndChargetypenameByCaseid(int id);
}