package com.hyg.service;

import com.hyg.mapper.DefenseAdvantageMapper;
import com.hyg.pojo.DefenseAdvantage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
        return mapper.listAllData();
    }
}