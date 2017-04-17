package cn.itweet.modules.admin.article.repository;

import cn.itweet.modules.admin.article.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by whoami on 16/04/2017.
 */
public interface ArticleTagRepository extends JpaRepository<ArticleTag,Integer> {

}
