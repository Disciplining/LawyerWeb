package com.hyg.controller;

import com.hyg.pojo.DefenseAdvantage;
import com.hyg.service.DefenseAdvantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Generated;
import java.util.List;

@Controller
public class DefenseAdvantageController
{
    @Autowired
    @Qualifier("defenseAdvantageService")
    private DefenseAdvantageService service;

    /**
     * 获得所有数据
     * @return
     */
    @GetMapping("/listAllAdvantageDate")
    @ResponseBody
    List<DefenseAdvantage> listAllAdvantageDate()
    {
        return service.listAllData();
    }
}