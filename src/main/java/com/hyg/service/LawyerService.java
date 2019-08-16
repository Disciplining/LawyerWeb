package com.hyg.service;

import com.hyg.mapper.LawyerMapper;
import com.hyg.pojo.Article;
import com.hyg.pojo.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 律师
 */
@Service("lawyerService")
public class LawyerService {
    @Qualifier("lawyerMapper")
    @Autowired
    private LawyerMapper lawyerMapper;

    public List<Lawyer> findAllLawyer(){
        return lawyerMapper.findAllLawyer();
    }

}
