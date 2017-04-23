package cn.itweet.modules.admin.article.service.categories;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Categories;

import java.util.List;

/**
 * Created by whoami on 17/04/2017.
 */
public interface CategoriesService {

    List<Categories> list();

    List<Categories> selectByName(String name);

    Categories getCategoriesByName(String name);

    void deleteById(Integer id);

    void update(Categories categories) throws SystemException;

    Categories addCategories(Categories categories) throws SystemException;

    Integer findCategoriesIdByArticleId(Integer articleId);
}
