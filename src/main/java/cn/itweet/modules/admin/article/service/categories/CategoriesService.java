package cn.itweet.modules.admin.article.service.categories;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Article;
import cn.itweet.modules.admin.article.entity.Categories;
import cn.itweet.modules.admin.article.utils.CategoriesDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by whoami on 17/04/2017.
 */
public interface CategoriesService {

    List<Categories> list();

    List<Categories> selectByName(String name);

    Categories getCategoriesByName(String name);

    void deleteById(Integer id) throws SystemException;

    void update(Categories categories) throws SystemException;

    Categories addCategories(Categories categories) throws SystemException;

    Integer findCategoriesIdByArticleId(Integer articleId);

    /**
     * 获取所有分类中拥有的文章数量
     * @return
     */
    List<CategoriesDto> getCategoriesArticleCount();
}
