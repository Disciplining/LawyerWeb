package com.hyg.service;


import com.github.pagehelper.PageHelper;
import com.hyg.mapper.ArticleMapper;
import com.hyg.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("articleService")
public class ArticleService {
    @Qualifier("articleMapper")
    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> findAllArticle(){
        return articleMapper.findAllArticle();
    }

	/**
	 * 全部文章类型的分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
    public Map<String, Object> listAllArticlePageData(int pageNum, int pageSize)
	{
		List<Article> list = articleMapper.findAllArticle(); // 分页之前查询为了长度

		PageHelper.startPage(pageNum, pageSize);
		List<Article> articles = articleMapper.findAllArticle();

		Map<String ,Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("count", list.size());
		map.put("data", articles);

		return map;
	}
}
