package com.hyg.mapper;

import com.hyg.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;
@Mapper
@Repository("menuMapper")
public interface MenuMapper {

    /**
     * 查询父级菜单
     */
    @Select("select * from t_menu where parentid=0")
    public List<Menu> findTopMenu();
    /**
     * 查询子菜单
     * */
    @Select("select * from t_menu where parentid =#{parentid}")
    public List<Menu> findSecondMenus(Integer parentid);
}
