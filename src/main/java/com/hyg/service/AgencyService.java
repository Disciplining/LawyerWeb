package com.hyg.service;

import com.hyg.mapper.AgencyMapper;
import com.hyg.pojo.Agency;
import com.hyg.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 事务所
 */
@Service("agencyService")
public class AgencyService {
    @Autowired
    @Qualifier("agencyMapper")
    private AgencyMapper agencyMapper;

    public List<Agency> findAgency()
    {
    	List<Agency> agencys = agencyMapper.findAgency();

    	// 富文本图片拼接主机地址
    	for (Agency agency : agencys)
		{
			agency.setAgencyDetail(Util.richTextAddHost(agency.getAgencyDetail()));
		}

        return agencys;
    }
}
