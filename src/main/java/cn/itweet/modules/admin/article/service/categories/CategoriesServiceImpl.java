package cn.itweet.modules.admin.article.service.categories;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Categories;
import cn.itweet.modules.admin.article.repository.ArticleCategoriesRepository;
import cn.itweet.modules.admin.article.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by whoami on 18/04/2017.
 */
@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private ArticleCategoriesRepository articleCategoriesRepository;

    @Override
    public List<Categories> list() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories getCategoriesByName(String name) {
        return categoriesRepository.getCategoriesByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        articleCategoriesRepository.deleteByCategoriesId(id);
        categoriesRepository.delete(id);
    }

    @Override
    public void update(Categories categories) throws SystemException {
        if ("" == categories.getName() || categories.getName() == null)
            throw new SystemException("更新失败，要更新的分类名称不能为空！");
        if (categoriesRepository.getCategoriesByName(categories.getName()) != null)
            throw new SystemException("添加失败，要更新的分类名称已经存在！");
        Categories c = categoriesRepository.getCategoriesByName(categories.getName());
        c.setName(categories.getName());
        c.setDate(new Date());
        categoriesRepository.save(c);
    }

    @Override
    public Categories addCategories(Categories categories) throws SystemException {
        if ("" == categories.getName() || categories.getName() == null)
            throw new SystemException("添加失败，要添加的分类名称不能为空！");
        if (categoriesRepository.getCategoriesByName(categories.getName()) != null)
            throw new SystemException("添加失败，要添加的分类名称已经存在！");

        return categoriesRepository.save(categories);
    }
}
