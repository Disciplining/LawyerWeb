package com.hyg.controller;

import com.hyg.pojo.DefenseDesc;
import com.hyg.service.DefenseDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 刑辨介绍表
 */
@Controller
public class DefenseDescController
{
	@Autowired
	@Qualifier("defenseDescService")
	private DefenseDescService service;

	/**
	 * 获得刑辨介绍表的数据，只有一条数据
	 * @return
	 */
	@GetMapping("/listDefenseDesc")
	@ResponseBody
	public List<DefenseDesc> listDefenseDesc()
	{
		return service.listDefenseDesc();
	}
}