package com.hyg.service;

import com.hyg.mapper.ChargeTypeMapper;
import com.hyg.mapper.ChargeTypeQuestionMapper;
import com.hyg.pojo.ChargeTypeQuestion;
import com.hyg.pojo.expand.ChargeTypeQuestionExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("chargeTypeQuestionService")
public class ChargeTypeQuestionService
{
	@Autowired
	@Qualifier("chargeTypeQuestionMapper")
	private ChargeTypeQuestionMapper mapper;

	@Autowired
	@Qualifier("chargeTypeMapper")
	private ChargeTypeMapper typeMapper;

	/**
	 * 获得问答表的数据
	 * 按照罪名的类型分类
	 */
	public List<Map<String, Object>> getQuestionDataSortByChargeType()
	{
		List<Map<String, Object>> data = new ArrayList<>();

		List<String> allChargeTypeName = typeMapper.listChargeTypeName();
		for (String typeName : allChargeTypeName)
		{
			Map<String, Object> temp = new HashMap<>(2);
			temp.put("chargeTypeName", typeName);  // 设置值1

			List<ChargeTypeQuestion> questions = mapper.listAllQuestionInOneType(typeName);
			// 将 ChargeTypeQuestion 对象转换成 ChargeTypeQuestionExtend对象
			List<ChargeTypeQuestionExtend> extendList = new ArrayList<>(questions.size());
			for (ChargeTypeQuestion foo : questions)
			{
				ChargeTypeQuestionExtend bar = new ChargeTypeQuestionExtend(foo, typeMapper.getOneChargetypenameById(foo.getChargeTypeId()));
				extendList.add(bar);
			}
			temp.put("questions", extendList); // 设置值2

			data.add(temp);
		}

		return data;
	}
}