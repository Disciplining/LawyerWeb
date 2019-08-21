package com.hyg.controller;

import com.hyg.pojo.ChargeTypeQuestion;
import com.hyg.service.ChargeTypeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ChargeTypeQuestionController
{
	@Autowired
	@Qualifier("chargeTypeQuestionService")
	private ChargeTypeQuestionService service;

	/**
	 * 获得问答表的数据
	 * 按照罪名的类型分类
	 * @return
	 */
	@GetMapping("/getQuestionDataSortByChargeType")
	@ResponseBody
	public List<Map<String, Object>> getQuestionDataSortByChargeType()
	{
		return service.getQuestionDataSortByChargeType();
	}

	/**
	 * 根据id获得一条数据
	 * @param id
	 * @return
	 */
	@GetMapping("/getOneQuestionById")
	@ResponseBody
	public ChargeTypeQuestion getOneQuestionById(@RequestParam("id") int id)
	{
		return service.getOneQuestionById(id);
	}
}