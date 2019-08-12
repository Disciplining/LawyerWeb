package com.hyg.controller;

import com.hyg.pojo.Menu;
import com.hyg.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 菜单控制器
 */
@Controller
public class MenuController {
    @Autowired
    @Qualifier("menuService")
    public MenuService menuService;

    @ResponseBody
    @RequestMapping("/firstMenu")
    public List<Menu> findMenu(){
        return menuService.findTopMenu();
    }
    @ResponseBody
    @RequestMapping("/secondMenu")
    public List<Menu> findMenus(int parentId ){

        return menuService.findTopMenus();
    }

}
