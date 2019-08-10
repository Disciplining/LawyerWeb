package com.hyg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 菜单控制器
 */
@Controller
public class MenuController {
    @ResponseBody
    @RequestMapping("/firstMenu")
    public String  findMenu(){
        return "hello";
    }

}
