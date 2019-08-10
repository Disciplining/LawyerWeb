package com.hyg.mapper;

import com.hyg.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository("deleteMapper")
public interface MenuMapper {

    /**
     * 查询父级菜单
     */
    @Select("select * from t_menu where ")
    public List<Menu> findTopMenu();

}
