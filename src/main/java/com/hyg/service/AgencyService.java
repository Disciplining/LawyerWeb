package com.hyg.service;

import com.hyg.mapper.AgencyMapper;
import com.hyg.pojo.Agency;
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
        return  agencyMapper.findAgency();
    }
}
