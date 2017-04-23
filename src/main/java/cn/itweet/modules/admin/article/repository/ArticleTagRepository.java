package cn.itweet.modules.admin.article.repository;

import cn.itweet.modules.admin.article.entity.ArticleTag;
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
public interface ArticleTagRepository extends JpaRepository<ArticleTag,Integer> {

    @Query("delete from ArticleTag where tagId=?1")
    @Modifying
    void deleteByTagId(Integer tagId);

    @Query(value = "delete from Article_Tag where article_id=?1",nativeQuery = true)
    @Modifying
    void deleteByArticleId(Integer articleId);

    @Query("delete from ArticleTag where articleId=?1 and tagId=?2")
    @Modifying
    void deleteByArticleIdAndTagId(Integer articleId, Integer TagId);

    @Query("select tagId from ArticleTag where articleId=?1")
    List<Integer> getTagIdsByArticleId(Integer articleId);

    @Query(value = "select group_concat(c.name) from (select b.name from (select tag_id from article_tag where article_id = ?1) a left join tag b on a.tag_id=b.id) c",nativeQuery = true)
    String findTagNamesByArticleId(Integer articleId);
}
