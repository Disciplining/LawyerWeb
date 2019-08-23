package com.hyg.util;

import com.hyg.pojo.Article;

import java.util.List;

public class Util
{
	/**
	 * 富文本中的图片拼接 主机地地
	 * @param richText
	 * @return
	 */
	public static String richTextAddHost(String richText)
	{
		return richText.replace("<img src=\"", "<img src=\"" + NetUtil.getPcHost());
	}

	/**
	 * 输入：文章的实体集合
	 * 将集合中的每个实体中的富文本中的图片都拼接上主机地址
	 * @param list
	 */
	public static void richTextAddHostAll(List<Article> list)
	{
		for (Article article : list)
		{
			article.setContent(richTextAddHost(article.getContent()));
		}
	}
}