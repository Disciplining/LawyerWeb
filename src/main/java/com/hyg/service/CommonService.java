package com.hyg.service;


import com.hyg.mapper.CaseMapper;
import com.hyg.mapper.ChargeMapper;
import com.hyg.mapper.ChargeTypeMapper;
import com.hyg.mapper.ChargeTypeQuestionMapper;
import com.hyg.pojo.Case;
import com.hyg.util.ChangeNameAndCases;
import com.hyg.util.LinkageCaseDataBean;
import com.hyg.util.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commonService")
public class CommonService
{
	@Autowired
	@Qualifier("chargeTypeMapper")
	private ChargeTypeMapper chargeTypeMapper;

	@Autowired
	@Qualifier("chargeMapper")
	private ChargeMapper chargeMapper;

	@Autowired
	@Qualifier("caseMapper")
	private CaseMapper caseMapper;

	@Autowired
	@Qualifier("chargeTypeQuestionMapper")
	private ChargeTypeQuestionMapper questionMapper;

	/**
	 * 获得 网站下方 展示案例的联动数据
	 * @return
	 */
	public List<LinkageCaseDataBean> getLinkageCaseData()
	{
		List<LinkageCaseDataBean> data = new ArrayList<>();

		List<String> allChargeTypeName = chargeTypeMapper.listChargeTypeName(); // 获得所有的罪名分类的名称
		for (String foo : allChargeTypeName) // 遍历每个罪名分类的名称
		{
			LinkageCaseDataBean bean = new LinkageCaseDataBean(); // 要存入最终集合的对象

			/*-----------为 charTypeName 赋值-----------*/
			bean.setCharTypeName(foo);
			/*-----------------------------------------*/

			/*-----------为 chargeNamesAndCases 赋值----------- */
			List<String> allChangeNameInThisType = chargeMapper.listAllChargeNameByChargeTypeName(foo); // 获得这个罪名分类下的所有罪名的名称: 民事罪  抢劫

			List<ChangeNameAndCases> chargeNamesAndCases = new ArrayList<>(); // 内部list

			for(String charName : allChangeNameInThisType) // 遍历 这个罪名分类下的 所有罪名
			{
				ChangeNameAndCases temp = new ChangeNameAndCases();
				temp.setChargeName(charName);
				List<Case> cases = caseMapper.getAllCaseByChargeName(charName); // 这个罪名下的所有案例
				for(Case onCase : cases)
				{
					onCase.setPicUrl(NetUtil.getPcHost().append(onCase.getPicUrl()).toString()); // 拼接主机地址
				}
				temp.setCases(cases);

				System.out.println("debug：" + cases);

				chargeNamesAndCases.add(temp);
			}
			bean.setChargeNamesAndCases(chargeNamesAndCases);
			/*-------------------------------------------------*/

			data.add(bean);
		}

		return data;
	}

	/**
	 * 获得刑事辨护模块下的数据
	 * 包括：这个罪名分类下的罪名实体  这个罪名分类下的问答实体
	 * @param chargeTypeName 毒品类犯罪辩护、公司企业人员犯罪预防与辩护、时下热点罪名辩护
	 * @return
	 */
	public Map<String,Object> getCriminalDefenseData(String chargeTypeName)
	{
		Map<String, Object> map = new HashMap<>(2);
		map.put("charges", chargeMapper.listChargeByChargeTypeName(chargeTypeName));
		map.put("questions", questionMapper.listAllQuestionInOneType(chargeTypeName));

		return map;
	}
}