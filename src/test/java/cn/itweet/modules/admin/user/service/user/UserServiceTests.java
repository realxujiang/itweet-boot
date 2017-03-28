package cn.itweet.modules.admin.user.service.user;

import cn.itweet.ItweetBootApplication;
import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entity.SysUser;
import cn.itweet.modules.admin.user.repository.RoleUserRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whoami on 14/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItweetBootApplication.class)
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleUserRepository roleUserRepository;

    @Before
    public void setUp() {
        // userService.deleteAll();
    }

    @Test
    public void test() throws SystemException {

        addUserTests();

        deleteUserTests();

        updateUserTests();

        getUserTests();

        getAllUsersTest();
    }

    private void updateUserTests() throws SystemException {
        SysUser u1 = userService.findByUsername("itweet");
        u1.setUsername("itweet");
        u1.setEmail("itweet@itweet.cn");

        List<Integer> rIds = new ArrayList<>();
        rIds.add(2);
        rIds.add(1);

        userService.update(u1,rIds);
        Assert.assertNotNull(userService.findByUsername("itweet"));
    }

    private void deleteUserTests() {
        SysUser u1 = userService.findByUsername("hadoop");

        try {
            userService.deleteById(u1.getId());
        } catch (SystemException e) {
            e.printStackTrace();
        }

        Assert.assertNull(userService.findByUsername("hadoop"));
        Assert.assertEquals("[]",roleUserRepository.getRoleUserIdsByUid(u1.getId()).toString());
    }

    private void addUserTests() throws SystemException {
        SysUser u1 = new SysUser();
        u1.setUsername("hadoop");
        u1.setPassword("hadoop");

        List<Integer> ruList = new ArrayList<>();
        ruList.add(2);
        ruList.add(1);

        userService.add(u1,ruList);

        // test add user info
        SysUser su = userService.findByUsername(u1.getUsername());
        Assert.assertNotNull(su);
        Assert.assertTrue(ruList.equals(roleUserRepository.getRoleIdsByUid(su.getId())));
    }

    private void getUserTests() {
        SysUser u1 = userService.findByUsername("admin");
        Assert.assertNotNull(u1);
    }

    private void getAllUsersTest() {
        List<SysUser> u = userService.list();
        Assert.assertEquals(2,u.size());
    }
}
