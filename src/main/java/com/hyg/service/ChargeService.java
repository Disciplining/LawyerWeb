package com.hyg.service;

import com.hyg.mapper.ChargeMapper;
import com.hyg.pojo.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("chargeService")
public class ChargeService
{
	@Autowired
	@Qualifier("chargeMapper")
	private ChargeMapper mapper;

	/**
	 * 根据罪名的id 获得一个罪名实体
	 * @param id
	 * @return
	 */
	public Charge getOneChargeById(int id)
	{
		return mapper.getOneChargeById(id);
	}
}