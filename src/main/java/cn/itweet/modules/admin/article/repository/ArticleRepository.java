package cn.itweet.modules.admin.article.repository;

import cn.itweet.common.repository.BaseRepository;
import cn.itweet.modules.admin.article.entity.Article;
import cn.itweet.modules.admin.article.utils.ArticleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
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
public interface ArticleRepository extends BaseRepository<Article,Integer> {

    @Query("from Article where title=?1")
    Article getArticleByTitle(String title);

    @Query("select new cn.itweet.modules.admin.article.utils.ArticleDto(a.id,a.title,a.state,SUBSTRING(a.description,1,15),a.description,a.createDate,a.updateDate,a.author,a.coverPicture,a.typeArticle) from Article a where a.title like %:title%")
    Page<ArticleDto> searchByTitle(@Param("pageable") Pageable pageable, @Param("title") String title);

    @Query("select new cn.itweet.modules.admin.article.utils.ArticleDto(a.id,a.title,a.state,SUBSTRING(a.description,1,15),a.description,a.createDate,a.updateDate,a.author,a.coverPicture,a.typeArticle) from Article a where a.state=?1")
    Page<ArticleDto> list(@Param("pageable") Pageable pageable,Integer state);

    @Query("select new cn.itweet.modules.admin.article.utils.ArticleDto(a.id,a.title,a.state,SUBSTRING(a.description,1,15),a.description,a.createDate,a.updateDate,a.author,a.coverPicture,a.typeArticle) from Article a")
    Page<ArticleDto> list(@Param("pageable") Pageable pageable);

    @Query("select new cn.itweet.modules.admin.article.utils.ArticleDto(a.id,a.title,a.state,SUBSTRING(a.description,1,15),a.description,a.createDate,a.updateDate,a.author,a.coverPicture,a.typeArticle) from Article a where a.state=?1 and a.typeArticle=?2")
    Page<ArticleDto> list(@Param("pageable") Pageable pageable,Integer state,Integer typeArticle);

    @Query(value = "select a.* from article a left join article_categories b on a.id = b.article_id where a.state=?1 and b.categories_id=?2",nativeQuery = true)
    List<Article> listByCategoriesIdAndState(Integer state,Integer categoriesId);

    @Query(value = "select b.name from article_tag a left join tag b on a.tag_id=b.id where a.article_id=?1",nativeQuery = true)
    List<String> getArticleTagsByArticleId(Integer articleId);

}
