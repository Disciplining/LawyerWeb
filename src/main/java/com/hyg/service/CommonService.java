package com.hyg.service;


import com.hyg.mapper.CaseMapper;
import com.hyg.mapper.ChargeMapper;
import com.hyg.mapper.ChargeTypeMapper;
import com.hyg.pojo.Case;
import com.hyg.pojo.ChargeType;
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

		List<String> charTypeNames = chargeTypeMapper.listChargeTypeName();

		for (String charTypeName : charTypeNames)
		{
			LinkageCaseDataBean bean = new LinkageCaseDataBean();
			bean.setCharTypeName(charTypeName); // 设置罪名分类 名称

			ChargeType chargeType = chargeTypeMapper.getOneChargeTypeByName(charTypeName); // 根据 罪名分类名称 获得罪名分类
			int chargeTypeId = chargeType.getId(); // 获得这个罪名分类的id
			List<String> chargeNames = chargeMapper.listChargeNameByChargeTypeId(chargeTypeId); // 获得这个罪名分类下的所有罪名
			bean.setChargeNames(chargeNames); // 设置这个罪名分类下的所有罪名

			// 获得这些罪名名称对应案例
			List<Case> cases = new ArrayList<>();
			for (String foo : chargeNames)
			{
				cases.addAll(caseMapper.getOneCaseChargeName(foo));
			}
			bean.setCases(cases); // 设置所有的案例

			data.add(bean);
		}

		return data;
	}
}