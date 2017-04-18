package cn.itweet.modules.admin.article.service.article;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by whoami on 17/04/2017.
 */
public interface ArticleService {
    Page<Article> list(Pageable pageable);

    Article getArticleByTitle(String title);

    Article getArticleById(Integer id);

    List<Article> findByTitle(String string);

    void deleteById(Integer id);

    void deleteByTitle(String title);

    void update(Article article) throws SystemException;

    Article addArticle(Article article) throws SystemException;

    Map<String,Article> archives();
}
