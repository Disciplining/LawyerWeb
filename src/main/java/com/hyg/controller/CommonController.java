package com.hyg.controller;

import com.hyg.service.CommonService;
import com.hyg.util.LinkageCaseDataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CommonController
{
	@Autowired
	@Qualifier("commonService")
	private CommonService service;

	/**
	 * 获得 网站下方 展示案例的联动数据
	 * @return
	 */
	@GetMapping("/getLinkageCaseData")
	@ResponseBody
	public List<LinkageCaseDataBean> getLinkageCaseData()
	{
		return service.getLinkageCaseData();
	}

	/**
	 * 获得刑事辨护模块下的数据
	 * 包括：这个罪名分类下的罪名实体  这个罪名分类下的问答实体
	 * @param chargeTypeName 毒品类犯罪辩护、公司企业人员犯罪预防与辩护、时下热点罪名辩护
	 * @return
	 */
	@GetMapping("/getCriminalDefenseData")
	@ResponseBody
	public Map<String,Object> getCriminalDefenseData(@RequestParam("name") String chargeTypeName)
	{
		return service.getCriminalDefenseData(chargeTypeName);
	}
}