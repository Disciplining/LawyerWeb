package com.hyg.service;


import com.hyg.mapper.ArticleMapper;
import com.hyg.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleService {
    @Qualifier("articleMapper")
    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> findAllArticle(){
        return articleMapper.findAllArticle();
    }
}
