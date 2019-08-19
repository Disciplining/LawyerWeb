package com.hyg.controller;

import com.hyg.service.CommonService;
import com.hyg.util.LinkageCaseDataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}