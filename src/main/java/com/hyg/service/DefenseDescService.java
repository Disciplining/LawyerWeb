package com.hyg.service;

import com.hyg.mapper.DefenseDescMapper;
import com.hyg.pojo.DefenseDesc;
import com.hyg.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("defenseDescService")
public class DefenseDescService
{
	@Autowired
	@Qualifier("defenseDescMapper")
	private DefenseDescMapper mapper;

	/**
	 * 获得刑辨介绍表中的数据  只有一条数据
	 *
	 * @return
	 */
	public List<DefenseDesc> listDefenseDesc()
	{
		List<DefenseDesc> list = mapper.listDefenseDesc();

		for (DefenseDesc foo : list)
		{
			foo.setDesc(Util.richTextAddHost(foo.getDesc()));
		}

		return list;
	}
}