package com.hyg.mapper;


import com.hyg.pojo.Case;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("caseMapper")
public interface CaseMapper
{
	/**
	 * 根据案例所属的名称 获取这个罪名下的所有案例
	 * @param chargeName
	 * @return
	 */
	@Select(" select * from `t_case` " +
				" where `chargeId`=(select `id` from `t_charge` where `chargeName`=#{chargeName}) ")
	List<Case> getOneCaseChargeName(String chargeName);
}