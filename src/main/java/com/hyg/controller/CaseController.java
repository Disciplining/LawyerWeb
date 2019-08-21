package com.hyg.controller;

import com.hyg.pojo.Case;
import com.hyg.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CaseController
{
	@Autowired
	@Qualifier("caseService")
	private CaseService service;

	/**
	 * 根据 案例的id 获得一个 案例实体
	 * @param id
	 * @return
	 */
	@GetMapping("/getOneCaseById")
	@ResponseBody
	public Case getOneCaseById(@RequestParam("id") int id)
	{
		return service.getOneCaseById(id);
	}
}