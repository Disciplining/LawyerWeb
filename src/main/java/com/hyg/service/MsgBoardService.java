package com.hyg.service;

import com.hyg.mapper.MsgBoardMapper;
import com.hyg.pojo.MsgBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service("msgBoardService")
public class MsgBoardService
{
	@Autowired
	@Qualifier("msgBoardMapper")
	private MsgBoardMapper mapper;

	/**
	 * 添加一条留言
	 * 前端需要提供的字段：customerName、customerTel、caseDetail
	 * 后端需要的字段：customerName*、customerTel、caseDetail、createDate
	 * @param msgBoard
	 * @return
	 */
	public boolean insertOneMsg(MsgBoard msgBoard)
	{
		msgBoard.setCreateDate(new Timestamp(System.currentTimeMillis()));

		try
		{
			mapper.insertOneMsg(msgBoard);
		}
		catch (Exception e)
		{
			System.out.println("出现异常：" + e.getMessage());
			return false;
		}

		return true;
	}
}