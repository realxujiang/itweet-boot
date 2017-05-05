package cn.itweet.modules.admin.article.service.article;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Article;
import cn.itweet.modules.admin.article.utils.ArticleDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by whoami on 17/04/2017.
 */
public interface ArticleService {

    Page<ArticleDto> list(Integer page);

    Page<ArticleDto> list(Integer page,Integer state);

    Page<ArticleDto> list(Integer page,Integer state,Integer articleType);

    Map<String, List<ArticleDto>> archive();

    Page<ArticleDto> searchByTitle(Integer page, String title);

    List<String> getArticleTagsByArticleId(Integer articleId);

    List<ArticleDto> getArticleRecentPostsTopN(Integer topNum);

    Article getArticleByTitle(String title);

    Article getArticleById(Integer id);

    void deleteById(Integer id);

    void deleteByTitle(String title);

    void update(Article article, String tagNames, Integer categoriesId) throws SystemException;

    void update(Article article) throws SystemException;

    Article addArticle(Article article, String tagNames, Integer categoriesId) throws SystemException;

    List<Article> listByCategoriesIdAndState(Integer state, Integer categoriesId);
}
