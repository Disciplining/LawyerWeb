package com.hyg.service;

import com.hyg.mapper.CaseMapper;
import com.hyg.pojo.Case;
import com.hyg.util.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("caseService")
public class CaseService
{
	@Autowired
	@Qualifier("caseMapper")
	private CaseMapper mapper;

	/**
	 * 根据 案例的id 获得一个 案例实体
	 * @param id
	 * @return
	 */
	public Case getOneCaseById(int id)
	{
		Case oneCase = mapper.getOneCaseById(id);

		oneCase.setPicUrl(NetUtil.getPcHost().append(oneCase.getPicUrl()).toString());

		return oneCase;
	}
}