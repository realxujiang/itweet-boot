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

    @Query("delete from ArticleTag where articleId=?1")
    @Modifying
    List<Integer> deleteByArticleId(Integer articleId);
}
