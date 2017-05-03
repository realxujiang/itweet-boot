package cn.itweet.modules.admin.article.repository;

import cn.itweet.modules.admin.article.entity.ArticleCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whoami on 16/04/2017.
 */
@Repository
@Transactional
public interface ArticleCategoriesRepository extends JpaRepository<ArticleCategories,Integer> {
    @Query("delete from ArticleCategories where categoriesId=?1")
    @Modifying
    void deleteByCategoriesId(Integer categoriesId);

    @Query(value = "delete from Article_Categories where article_id=?1",nativeQuery = true)
    @Modifying
    void deleteByArticleId(Integer articleId);

    @Query("select categoriesId from ArticleCategories where articleId=?1")
    Integer getCategoriesIdByArticleId(Integer articleId);

    List<ArticleCategories> findByCategoriesId(Integer categoriesId);
}
