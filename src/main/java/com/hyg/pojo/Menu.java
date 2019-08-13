package com.hyg.pojo;

import lombok.Data;

import java.util.List;

/**
 * 菜单表
 */
@Data
public class Menu
{
	private Integer menuId;
	private String menuName;
	private Integer parentId;
	private String router;
	private List<Menu> children;
}