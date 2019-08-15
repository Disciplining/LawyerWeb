package com.hyg.controller;


import com.hyg.pojo.Agency;
import com.hyg.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 事务所控制器
 */
@Controller
public class AgencyController
{
    @Autowired
    @Qualifier("agencyService")
    public AgencyService agencyService;

    @ResponseBody
    @RequestMapping("/agency")
    public List<Agency> findAgency()
	{
        return agencyService.findAgency();
    }
}
