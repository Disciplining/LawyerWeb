package com.hyg.mapper;

import com.hyg.pojo.MsgBoard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("msgBoardMapper")
public interface MsgBoardMapper
{
	/**
	 * 添加一条留言
	 * 添加的添加的字段：customerName、customerTel、caseDetail、createDate
	 * @param msgBoard
	 */
	@Insert(" insert into `t_msgBoard` (`customerName`,`customerTel`,`caseDetail`,`createDate`) " +
				" values (#{customerName},#{customerTel},#{caseDetail},#{createDate}) ")
	void insertOneMsg(MsgBoard msgBoard);
}