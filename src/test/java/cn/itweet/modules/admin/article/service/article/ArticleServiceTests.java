package cn.itweet.modules.admin.article.service.article;

import cn.itweet.ItweetBootApplication;
import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Article;
import cn.itweet.modules.admin.article.service.categories.CategoriesService;
import cn.itweet.modules.admin.article.service.tag.TagService;
import cn.itweet.modules.admin.article.utils.ArticleDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by whoami on 20/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItweetBootApplication.class)
public class ArticleServiceTests {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoriesService categoriesService;

    @Test
    public void test() throws SystemException {
        // addArticleTest();
        // getArticleTest();
        // listTest();
        // searchByTitileTest();

        // updateTest();

        // deleteByTitleTest();
        // deleteByIdTest();
        // getArticleRecentPostsTopNTest();
    }

    private void getArticleRecentPostsTopNTest() {
        articleService.getArticleRecentPostsTopN(10);
    }

    private void deleteByIdTest() throws SystemException {
        addArticleTest();
        articleService.deleteById(articleService.getArticleByTitle("First blog test").getId());
    }

    private void deleteByTitleTest() {
        articleService.deleteByTitle("First blog test");
    }

    private void updateTest() throws SystemException {
        Article article = articleService.getArticleByTitle("First blog test");
        article.setAuthor("super_admin");

        String tagNames = "DeepGreen,drill,BlueData";

        articleService.update(article,tagNames,categoriesService.getCategoriesByName("cloud").getId());
    }

    private void searchByTitileTest() {
        //System.out.println(articleService.searchByTitle("blog").get(0).toString());
        //Assert.assertEquals(1,articleService.searchByTitle("blog").size());
    }

    private void listTest() {
        List<ArticleDto> articleList = articleService.list(0).getContent();
        Assert.assertEquals(1,articleList.size());
    }

    private void getArticleTest() {
        Article article = articleService.getArticleByTitle("First blog test");
        Assert.assertNotNull(articleService.getArticleById(article.getId()));
    }

    private void addArticleTest() throws SystemException {
        Article article = new Article();
        article.setUpdateDate(new Date());
        article.setTitle("First blog test");
        article.setCreateDate(new Date());
        article.setContent("To transfer an Ambari Server that uses the default, embedded, PostgreSQL database from one host to a new host, use the following instructions:");
        article.setDescription("To transfer an Ambari Server that uses the default, embedded, PostgreSQL database from one host to a new host, use the following instructions:".substring(0,20));
        article.setAuthor("admin");

        String tagNames = "DeepGreen,drill,BlueData";

        Article ar = articleService.addArticle(article,tagNames,categoriesService.getCategoriesByName("cloud").getId());
        Assert.assertNotNull(ar);
    }
}
