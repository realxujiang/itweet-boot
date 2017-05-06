package cn.itweet.modules.admin.user.repository;

import cn.itweet.ItweetBootApplication;
import cn.itweet.modules.admin.user.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by whoami on 14/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItweetBootApplication.class)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testExample() throws Exception {
//        SysUser user = userRepository.findByUsername("admin");
//        Assert.assertEquals("admin",user.getUsername());
    }
}
