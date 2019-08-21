package com.hyg.controller;

import com.hyg.pojo.MsgBoard;
import com.hyg.service.MsgBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MsgBoardController
{
	@Autowired
	@Qualifier("msgBoardService")
	private MsgBoardService service;

	/**
	 * 添加一条留言
	 * 前端需要提供的字段：customerName、customerTel、caseDetail
	 * @param msgBoard
	 * @return
	 */
	@PostMapping("/insertOneMsg")
	@ResponseBody
	public boolean insertOneMsg(@RequestBody MsgBoard msgBoard)
	{
		return service.insertOneMsg(msgBoard);
	}
}