package cn.itweet.modules.admin.document.service;

import cn.itweet.ItweetBootApplication;
import cn.itweet.modules.admin.document.entiry.Document;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by whoami on 23/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItweetBootApplication.class)
public class StorageServiceTests {

    @Autowired
    private StorageService storageService;

    @Test
    public void test() {
        // loadAllTest();
        // loadRuleFilenameByIdTest();
        // loadByIdTest();
        // deleteByIdTest();
        // deleteByRuleFilenameTest();
        // deleteAllTest();
    }

    private void deleteAllTest() {
        storageService.deleteAll("/data/gitlab/itweet-boot/src/main/webapp/upload/files");
    }

    private void deleteByRuleFilenameTest() {
        storageService.deleteByRuleFilename("becoming-steve-jobs-20170423-093108.jpeg","/data/gitlab/itweet-boot/src/main/webapp/upload/files");
    }

    private void deleteByIdTest() {
        storageService.deleteById(14,"/data/gitlab/itweet-boot/src/main/webapp/upload/files");
        Assert.assertNull(storageService.loadById(14));
    }

    private void loadByIdTest() {
        Document document = storageService.loadById(14);
        Assert.assertNotNull(document);
    }

    private void loadRuleFilenameByIdTest() {
        String ruleFilename = storageService.loadRuleFilenameById(14);
        System.out.println(ruleFilename);
    }

}
