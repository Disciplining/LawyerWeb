package com.hyg.service;

import com.hyg.mapper.DefenseAdvantageMapper;
import com.hyg.pojo.DefenseAdvantage;
import com.hyg.util.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service("defenseAdvantageService")
public class DefenseAdvantageService
{
    @Autowired
    @Qualifier("defenseAdvantageMapper")
    private DefenseAdvantageMapper mapper;

    /**
     * 获得所有数据
     * @return
     */
    public List<DefenseAdvantage> listAllData()
    {
    	List<DefenseAdvantage> list = mapper.listAllData();

    	// 拼接主机地址
    	for (DefenseAdvantage foo : list)
		{
			foo.setIcon(NetUtil.getPcHost().append(foo.getIcon()).toString());
		}

        return list;
    }

	/**
	 * 根据id获取一条数据
	 * @param id
	 * @return
	 */
	public DefenseAdvantage getOneDefenseAdvantageById(@RequestParam("id") int id)
	{
		return mapper.getOneDefenseAdvantageById(id);
	}
}