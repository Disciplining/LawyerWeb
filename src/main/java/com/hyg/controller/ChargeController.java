package com.hyg.controller;

import com.hyg.pojo.Charge;
import com.hyg.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChargeController
{
	@Autowired
	@Qualifier("chargeService")
	private ChargeService service;

	/**
	 * 根据罪名的id 获得一个罪名实体
	 * @param id
	 * @return
	 */
	@GetMapping("/getOneChargeById")
	@ResponseBody
	public Charge getOneChargeById(@RequestParam("id") int id)
	{
		return service.getOneChargeById(id);
	}
}