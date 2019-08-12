package com.hyg.service;

import com.hyg.mapper.MenuMapper;
import com.hyg.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuService {

    @Autowired
    @Qualifier("menuMapper")
    private MenuMapper menuMapper;

    public List<Menu> findTopMenu()
    {
        return menuMapper.findTopMenu();
    }
    public  List<Menu> findSecondMenus(Integer parentId){
        return menuMapper.findSecondMenus(parentId);
    }

}
