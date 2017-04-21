package cn.itweet.modules.admin.article.service.tag;

import cn.itweet.ItweetBootApplication;
import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Tag;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by whoami on 20/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItweetBootApplication.class)
public class TagServiceTests {

    @Autowired
    private TagService tagService;

    @Test
    public void test() throws SystemException {
        // addTagTest();

        //getTagByNameTest();

        //listTest();

        //updateTest();

        //deleteByIdTest();
    }

    private void deleteByIdTest() {
        tagService.deleteById(tagService.getTagByName("spark").getId());
    }

    private void updateTest() throws SystemException {
        Tag tag = tagService.getTagByName("impala");
        tag.setName("spark");
        tagService.update(tag);
    }

    private void listTest() {
        Page<Tag> tags = tagService.list(new PageRequest(0,10));
        Assert.assertEquals(1,tags.getContent().size());
    }

    private void getTagByNameTest() {
        Assert.assertNotNull(tagService.getTagByName("impala"));
    }

    private void addTagTest() throws SystemException {
        Tag t = tagService.addTag(new Tag("impala",new Date()));
//        tagService.addTag(new Tag("hawq",new Date()));
//        tagService.addTag(new Tag("drill",new Date()));
//        tagService.addTag(new Tag("DeepGreen",new Date()));
//        tagService.addTag(new Tag("Itweet",new Date()));
//        tagService.addTag(new Tag("BlueData",new Date()));
        Assert.assertEquals("impala",t.getName());
    }
}
