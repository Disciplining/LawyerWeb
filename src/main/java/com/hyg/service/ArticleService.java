package com.hyg.service;


import com.github.pagehelper.PageHelper;
import com.hyg.mapper.ArticleMapper;
import com.hyg.pojo.Article;
import com.hyg.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("articleService")
public class ArticleService
{
	@Qualifier("articleMapper")
	@Autowired
	private ArticleMapper articleMapper;

	public List<Article> findAllArticle()
	{
		List<Article> list = articleMapper.findAllArticle();

		Util.richTextAddHostAll(list);

		return list;
	}

	/**
	 * 全部文章类型的分页数据
	 *
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> listAllArticlePageData(int pageNum, int pageSize)
	{
		List<Article> list = articleMapper.findAllArticle(); // 分页之前查询为了长度

		PageHelper.startPage(pageNum, pageSize);
		List<Article> articles = articleMapper.findAllArticle();

		Util.richTextAddHostAll(articles);

		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("count", list.size());
		map.put("data", articles);

		return map;
	}

	/**
	 * 公司法律文章的分页数据
	 *
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> listCompanyLawArticlePageData(int pageNum, int pageSize)
	{
		List<Article> list = articleMapper.findCompanyLawArticle(); // 分页之前查询为了长度

		PageHelper.startPage(pageNum, pageSize);
		List<Article> articles = articleMapper.findCompanyLawArticle();

		Util.richTextAddHostAll(articles);

		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("count", list.size());
		map.put("data", articles);

		return map;
	}

	/**
	 * 劳动法律文章的分页数据
	 *
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> listLabourLawArticlePageData(int pageNum, int pageSize)
	{
		List<Article> list = articleMapper.findLabourLawArticle(); // 分页之前查询为了长度

		PageHelper.startPage(pageNum, pageSize);
		List<Article> articles = articleMapper.findLabourLawArticle();

		Util.richTextAddHostAll(articles);

		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("count", list.size());
		map.put("data", articles);

		return map;
	}

	/**
	 * 刑事法律文章分页数据
	 *
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> listCriminalLawArticlePageData(int pageNum, int pageSize)
	{
		List<Article> list = articleMapper.findCriminalLawArticle(); // 分页之前查询为了长度

		PageHelper.startPage(pageNum, pageSize);
		List<Article> articles = articleMapper.findCriminalLawArticle();

		Util.richTextAddHostAll(articles);

		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("count", list.size());
		map.put("data", articles);

		return map;
	}

	/**
	 * 所有文章类型下的详情接口
	 *
	 * @param id
	 * @return
	 */
	public Map<String, Object> allTypeDetail(int id)
	{
		Map<String, Object> map = new HashMap<>(2);

		map.put("idArr", articleMapper.listAllArticleId());

		Article article = articleMapper.getOneArticleById(id);
		article.setContent(Util.richTextAddHost(article.getContent()));

		map.put("articleDetail", article);

		return map;
	}

	/*-----------------------------------------------------------------------------------*/

	/**
	 * 公司法律文章类型下的详情接口
	 *
	 * @param id
	 * @return
	 */
	public Map<String, Object> companyTypeDetail(int id)
	{
		Map<String, Object> map = new HashMap<>(2);

		map.put("idArr", articleMapper.listCompanyArticleId());

		Article article = articleMapper.getOneArticleById(id);
		article.setContent(Util.richTextAddHost(article.getContent()));
		map.put("articleDetail", article);

		return map;
	}

	/**
	 * 劳动法律
	 *
	 * @param id
	 * @return
	 */
	public Map<String, Object> labourTypeDetail(int id)
	{
		Map<String, Object> map = new HashMap<>(2);

		map.put("idArr", articleMapper.listLabourArticleId());

		Article article = articleMapper.getOneArticleById(id);
		article.setContent(Util.richTextAddHost(article.getContent()));
		map.put("articleDetail", article);

		return map;
	}

	/**
	 * 刑事法律
	 *
	 * @param id
	 * @return
	 */
	public Map<String, Object> criminalTypeDetail(int id)
	{
		Map<String, Object> map = new HashMap<>(2);

		map.put("idArr", articleMapper.listLCriminalArticleId());

		Article article = articleMapper.getOneArticleById(id);
		article.setContent(Util.richTextAddHost(article.getContent()));
		map.put("articleDetail", article);

		return map;
	}
}
