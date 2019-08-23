package com.hyg.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class NetUtil
{
	// 程序使用的端口
	private static String port;

	// 主机的地址
	// 没有虚拟机的情况下就是第一个
	private static final String host = getAllIpAddr().get(0);

	/**
	 * 获得主机地址
	 * http://xxxx:xx
	 * 最后没有 "/"
	 * @return
	 */
	public static StringBuffer getPcHost()
	{
		return new StringBuffer("http://" + host + ":" + port);
	}

	/**
	 * 获得主机上所有网卡的IP
	 * 包括虚拟网卡
	 * @return
	 */
	private static List<String> getAllIpAddr()
	{
		List<String> ipList = new ArrayList<String>();
		try
		{
			for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces()))
			{
				if (networkInterface.isVirtual())
					continue;
				if (!networkInterface.isUp())
					continue;
				for (InetAddress addr : Collections.list(networkInterface.getInetAddresses()))
				{
					if (!addr.isLoopbackAddress() && !addr.isLinkLocalAddress()
							&& addr.isSiteLocalAddress())
					{
						ipList.add(addr.getHostAddress().toString());
					}
				}
			}

			System.out.println(ipList);
		}
		catch (SocketException e)
		{
			System.out.println("出现异常：" + e.getLocalizedMessage());

			ipList.clear();
			ipList.add("");
		}

		return ipList;
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