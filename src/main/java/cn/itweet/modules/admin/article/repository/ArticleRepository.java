package cn.itweet.modules.admin.article.repository;

import cn.itweet.modules.admin.article.entity.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by whoami on 16/04/2017.
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article,Integer> {

}
