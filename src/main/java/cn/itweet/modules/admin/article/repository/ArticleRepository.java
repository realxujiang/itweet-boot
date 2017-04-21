package cn.itweet.modules.admin.article.repository;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whoami on 16/04/2017.
 */
@Repository
@Transactional
public interface ArticleRepository extends PagingAndSortingRepository<Article,Integer> {

    @Query("from Article where title=?1")
    Article getArticleByTitle(String title);

    @Query(value = "select a from Article a where a.title like %:title%")
    Page<Article> searchByTitle(@Param("pageable") Pageable pageable,@Param("title") String title);

}
