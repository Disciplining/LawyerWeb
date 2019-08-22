package com.hyg.controller;

import com.hyg.pojo.Article;
import com.hyg.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 文集控制器
 */
@Controller
public class ArticleController
{
    @Qualifier("articleService")
    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping("/articleList")
    public List<Article> findAllArticle()
    {
    	return articleService.findAllArticle();
    }

	/**
	 * 全部文章分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
    @GetMapping("/allArticlePageData")
	@ResponseBody
    public Map<String, Object> allArticlePageData
	(
		@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize
	)
	{
		return articleService.listAllArticlePageData(pageNum, pageSize);
	}

	/**
	 * 公司法律文章分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/companyLawArticlePageData")
	@ResponseBody
	public Map<String, Object> companyLawArticlePageData
	(
		@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize
	)
	{
		return articleService.listCompanyLawArticlePageData(pageNum, pageSize);
	}

	/**
	 * 劳动法律文章分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/labourLawArticlePageData")
	@ResponseBody
	public Map<String, Object> labourLawArticlePageData
	(
		@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize
	)
	{
		return articleService.listLabourLawArticlePageData(pageNum, pageSize);
	}

	/**
	 * 刑事法律文章分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/criminalLawArticlePageData")
	@ResponseBody
	public Map<String, Object> criminalLawArticlePageData
	(
		@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize
	)
	{
		return articleService.listCriminalLawArticlePageData(pageNum, pageSize);
	}

	/**
	 * 所有类型下的详情按钮
	 * @param id
	 * @return
	 */
	@GetMapping("/allTypeDetail")
	@ResponseBody
	public Map<String, Object> allTypeDetail(@RequestParam("id") int id)
	{
		return articleService.allTypeDetail(id);
	}

	/*--------------------------------------------*/

	/**
	 * 公司法律类型下的详情按钮
	 * @param id
	 * @return
	 */
	@GetMapping("/companyTypeDetail")
	@ResponseBody
	public Map<String, Object> companyTypeDetail(@RequestParam("id") int id)
	{
		return articleService.companyTypeDetail(id);
	}

	/**
	 * 劳动法律
	 * @param id
	 * @return
	 */
	@GetMapping("/labourTypeDetail")
	@ResponseBody
	public Map<String, Object> labourTypeDetail(@RequestParam("id") int id)
	{
		return articleService.labourTypeDetail(id);
	}

	/**
	 * 劳动法律
	 * @param id
	 * @return
	 */
	@GetMapping("/criminalTypeDetail")
	@ResponseBody
	public Map<String, Object> criminalTypeDetail(@RequestParam("id") int id)
	{
		return articleService.criminalTypeDetail(id);
	}
}