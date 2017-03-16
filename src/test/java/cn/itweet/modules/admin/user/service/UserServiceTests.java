package cn.itweet.modules.admin.user.service;

import cn.itweet.ItweetBootApplication;
import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entity.SysUser;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by whoami on 14/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItweetBootApplication.class)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        userService.deleteAll();
    }

    @Test
    public void test() throws SystemException {
        getAllUsersTest();
    }

    private void getAllUsersTest() {
        Collection<SysUser> u = userService.getAllUsers();
        Assert.assertEquals(2,u.size());
    }
}
