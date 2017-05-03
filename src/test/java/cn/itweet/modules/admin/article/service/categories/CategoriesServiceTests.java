package cn.itweet.modules.admin.article.service.categories;

import cn.itweet.ItweetBootApplication;
import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Categories;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by whoami on 20/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItweetBootApplication.class)
public class CategoriesServiceTests {

    @Autowired
    private CategoriesService categoriesService;

    @Test
    public void test() throws SystemException {
        // addCategoriesTest();
        // getCategoriesByNameTest();
        // listTest();

        // updateTest();

        // deleteByIdTest();
    }

    private void deleteByIdTest() {
        try {
            categoriesService.deleteById(categoriesService.getCategoriesByName("cloudera").getId());
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }

    private void updateTest() throws SystemException {
        Categories categories = categoriesService.getCategoriesByName("cloud");
        categories.setName("cloudera");
        categories.setDate(new Date());
        categoriesService.update(categories);
    }

    private void listTest() {
        List<Categories> tagList = categoriesService.list();
        Assert.assertEquals(1,tagList.size());
    }

    private void getCategoriesByNameTest() {
        Categories categories = categoriesService.getCategoriesByName("cloud");
        Assert.assertNotNull(categories);
    }

    private void addCategoriesTest(){
        Categories categories = null;
        try {
            categories = categoriesService.addCategories(new Categories("cloud",new Date()));
//            categories = categoriesService.addCategories(new Categories("ambari",new Date()));
//            categories = categoriesService.addCategories(new Categories("hawq",new Date()));
//            categories = categoriesService.addCategories(new Categories("docker",new Date()));
        } catch (SystemException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(categories);
    }
}
