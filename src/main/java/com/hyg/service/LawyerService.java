package com.hyg.service;

import com.hyg.mapper.LawyerMapper;
import com.hyg.pojo.Lawyer;
import com.hyg.util.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 律师
 */
@Service("lawyerService")
public class LawyerService
{
	@Qualifier("lawyerMapper")
	@Autowired
	private LawyerMapper lawyerMapper;

	public List<Lawyer> findAllLawyer()
	{
		List<Lawyer> list = lawyerMapper.findAllLawyer();
		for (Lawyer la : list)
		{
			la.setLawyerImg( NetUtil.getPcHost().append(la.getLawyerImg()).toString() );
		}

		return list;
	}
}