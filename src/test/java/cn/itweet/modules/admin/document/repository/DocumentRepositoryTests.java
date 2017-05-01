package cn.itweet.modules.admin.document.repository;

import cn.itweet.ItweetBootApplication;
import cn.itweet.modules.admin.document.entiry.Document;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by whoami on 01/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItweetBootApplication.class)
public class DocumentRepositoryTests {

    @Autowired
    private DocumentRepository documentRepository;

    @Test
    public void test() {
        // testListByNativeSQL();
        // getNewDocumentTopNTest();
    }

    private void getNewDocumentTopNTest() {
        System.out.println(documentRepository.getNewDocumentTopN("index",4).toString());
    }

    private void testListByNativeSQL() {
        List<Object[]> list = documentRepository.listBySQL("select columnd,count(*) from document group by columnd");
        Assert.assertEquals(3,list.size());
        Assert.assertEquals("article",list.get(0)[0]);

        List<Document> list2 = documentRepository.findByColumndAndType("index","jpg");
        System.out.println(list2.toString());
        Assert.assertEquals(4,list2.size());
    }
}
