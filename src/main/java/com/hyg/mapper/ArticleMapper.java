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
    List<Article> findAllArticle();

	/**
	 * 查询公司法律的文章
	 * @return
	 */
	@Select(" select * from t_article WHERE deleteFlag='0' and type=1 ")
	List<Article> findCompanyLawArticle();

	/**
	 * 查询劳动法律的所有文章
	 * @return
	 */
	@Select(" select * from t_article WHERE deleteFlag='0' and type=2 ")
	List<Article> findLabourLawArticle();

	/**
	 * 查询刑事法律的所有文章
	 * @return
	 */
	@Select(" select * from t_article WHERE deleteFlag='0' and type=3 ")
	List<Article> findCriminalLawArticle();

	/**
	 * 根据id获得一篇文章
	 * @param articleId
	 * @return
	 */
	@Select(" select * from `t_article` where `deleteFlag`!='1' and `articleId`=#{articleId} ")
	Article getOneArticleById(int articleId);
}
