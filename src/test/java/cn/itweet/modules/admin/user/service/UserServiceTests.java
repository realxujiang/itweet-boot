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
import java.util.Optional;

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
        // userService.deleteAll();
    }

    @Test
    public void test() throws SystemException {
        // updateUserTests();

        // deleteUserTests();

        // addUserTests();

        getUserTests();

        // getAllUsersTest();
    }

    private void updateUserTests() throws SystemException {
        SysUser u1 = userService.findByUsername("admin");
        SysUser u2 = new SysUser();
        u2.setId(u1.getId());
        u2.setUsername("admin");
        //userService.update(u2);
        //Assert.assertEquals("admin",userService.get(u1.getId()).get().getUsername());
    }

    private void deleteUserTests() {
        SysUser u1 = userService.findByUsername("itweet");
        //userService.delete(u1.getId());
        Assert.assertNull(userService.findByUsername("itweet"));
    }

    private void addUserTests() throws SystemException {
        SysUser u1 = new SysUser();
        u1.setUsername("itweet");
        u1.setPassword("123");

        SysUser u2 = userService.add(u1);

        //Assert.assertEquals(userService.get(u2.getId()).get().getUsername(),u2.getUsername());
    }

    private void getUserTests() {
        SysUser u1 = userService.findByUsername("admin");
        //Optional<SysUser> u = userService.get(u1.getId());

        //Assert.assertEquals("admin",u.get().getUsername());
    }

    private void getAllUsersTest() {
        //Collection<SysUser> u = userService.getAll();
        //Assert.assertEquals(2,u.size());
    }
}
