package cn.itweet.modules.admin.user.service;

import cn.itweet.ItweetBootApplication;
import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entry.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
        insertUserTest();

        getAllUsersTest();

    }

    private void getAllUsersTest() {
        Collection<User> u = userService.getAllUsers();
        Assert.assertEquals(1,u.size());
    }

    private void insertUserTest() {
        User u = new User();
        u.setUserid((long) 1);
        u.setEmail("admin@itweet.cn");
        u.setEnabled(1);
        u.setUserName("admin");
        u.setPassword("admin");

        User ru = null;
        try {
            ru = userService.insertUser(u);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("admin@itweet.cn",ru.getEmail());
        Assert.assertEquals("admin",ru.getUserName());
    }

}
