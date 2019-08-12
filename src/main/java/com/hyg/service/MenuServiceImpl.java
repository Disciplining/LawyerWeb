package com.hyg.service;

import com.hyg.mapper.MenuMapper;
import com.hyg.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl extends MenuService {
    @Autowired
    @Qualifier("deleteMapper")
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findTopMenu()
    {
        return menuMapper.findTopMenu();
    }

    public List<Menu> findTopMenus(){ return menuMapper.findTopMenus(); }
}