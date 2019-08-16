package com.hyg.mapper;

import com.hyg.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文集
 */
@Mapper
@Repository("articleMapper")
public interface ArticleMapper {
    @Select("select * from t_article WHERE deleteFlag='0'")
    public List<Article> findAllArticle();
}
