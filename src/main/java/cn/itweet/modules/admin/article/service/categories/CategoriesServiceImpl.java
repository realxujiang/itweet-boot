package cn.itweet.modules.admin.article.service.categories;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Categories;
import cn.itweet.modules.admin.article.repository.ArticleCategoriesRepository;
import cn.itweet.modules.admin.article.repository.CategoriesRepository;
import cn.itweet.modules.admin.article.utils.CategoriesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.util.ArrayList;
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
    public List<Categories> selectByName(String name) {
        return categoriesRepository.selectByName(name);
    }

    @Override
    public Categories getCategoriesByName(String name) {
        return categoriesRepository.getCategoriesByName(name);
    }

    @Override
    public void deleteById(Integer id) throws SystemException {
        System.out.println("=====>"+articleCategoriesRepository.findByCategoriesId(id).toString());
        if (articleCategoriesRepository.findByCategoriesId(id).size()>0)
            throw new SystemException("分类删除失败，要删除的分类中还有文章存在！");
        articleCategoriesRepository.deleteByCategoriesId(id);
        categoriesRepository.delete(id);
    }

    @Override
    public void update(Categories categories) throws SystemException {
        if ("" == categories.getName() || categories.getName() == null)
            throw new SystemException("更新失败，要更新的分类名称不能为空！");
        if (categoriesRepository.getCategoriesByName(categories.getName()) != null)
            throw new SystemException("更新失败，要更新的分类名称已经存在！");
        Categories c = categoriesRepository.findOne(categories.getId());
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

    @Override
    public Integer findCategoriesIdByArticleId(Integer articleId) {
        return articleCategoriesRepository.getCategoriesIdByArticleId(articleId);
    }

    @Override
    public List<CategoriesDto> getCategoriesArticleCount() {
        String sql = "select a.id,a.name,count(b.article_id) from categories a left join (select a.* from article_categories a left join article b on a.article_id = b.id where b.state=1) b on a.id = b.categories_id group by a.name";
        List<Object[]> list = categoriesRepository.listBySQL(sql);
        List<CategoriesDto> categoriesDtoList = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            Object[] obj = list.get(i);
            CategoriesDto categoriesDto = new CategoriesDto();
            categoriesDto.setId((Integer) obj[0]);
            categoriesDto.setName((String) obj[1]);
            categoriesDto.setCount(((BigInteger) obj[2]).intValue());
            categoriesDtoList.add(categoriesDto);
        }
        return categoriesDtoList;
    }
}
