package com.hyg.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NetUtil
{
	// 程序使用的端口
	private static String port;

	// 主机的地址
	private static final String host = "39.96.175.127";

	/**
	 * 获得主机地址
	 * 要接招到返回的图片上url上
	 * http://xxxx:xx
	 * 最后没有 "/"
	 * @return
	 */
	public static StringBuffer getPcHost()
	{
		return new StringBuffer("http://" + host + ":" + port);
	}

	/**
	 * 为 port 注入配置文件中的值
	 * @param port
	 */
	@Value("${server.port}")
	public void setPort(String port)
	{
		NetUtil.port = port;
	}
}