package com.hyg.service;


import com.hyg.mapper.CaseMapper;
import com.hyg.mapper.ChargeMapper;
import com.hyg.mapper.ChargeTypeMapper;
import com.hyg.pojo.Case;
import com.hyg.pojo.ChargeType;
import com.hyg.util.ChangeNameAndCases;
import com.hyg.util.LinkageCaseDataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
				temp.setCases(cases);

				chargeNamesAndCases.add(temp);
			}
			bean.setChargeNamesAndCases(chargeNamesAndCases);
			/*-------------------------------------------------*/

			data.add(bean);
		}

		return data;
	}
}