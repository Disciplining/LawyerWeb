package com.hyg.mapper;

import com.hyg.pojo.ChargeTypeQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 罪名分类问答表 mapper
 */
@Mapper
@Repository("chargeTypeQuestionMapper")
public interface ChargeTypeQuestionMapper
{
	/*查*/
	/**
	 * 获得所有的数据
	 * @return
	 */
	@Select(" select * from `t_chargeTypeQuestion` where `deleteFlag`!='1' ")
	List<ChargeTypeQuestion> listAllQuestion();

	/**
	 * 根据id获得一条数据
	 * @param id
	 * @return
	 */
	@Select(" select * from `t_chargeTypeQuestion` where `id`=#{id} and `deleteFlag`!='1' ")
	ChargeTypeQuestion getOneQuestionById(int id);

	/**
	 * 输入：某个罪名分类的名称
	 * 获得：这个罪名分类下的所有问答实体
	 * @param chargeTypeName
	 * @return
	 */
	@Select(" select * from `t_chargeTypeQuestion` where `chargeTypeId`=(select `id` from `t_chargeType` where `chargeTypeName`=#{chargeTypeName}) ")
	List<ChargeTypeQuestion> listAllQuestionInOneType(String chargeTypeName);
	/*------------------------------------------------------------------------*/
}