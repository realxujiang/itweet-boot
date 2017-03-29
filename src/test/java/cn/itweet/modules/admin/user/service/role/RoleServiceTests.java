package cn.itweet.modules.admin.user.service.role;

import cn.itweet.ItweetBootApplication;
import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entity.SysRole;
import cn.itweet.modules.admin.user.repository.PermissionRoleRepository;
import cn.itweet.modules.admin.user.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by whoami on 28/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItweetBootApplication.class)
public class RoleServiceTests {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionRoleRepository permissionRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws SystemException {
        // add();

        // deleteById();
        //list();
    }

    private void deleteById() throws SystemException {
        SysRole sysRole = roleService.findByRoleName("ROLE_ARTICLE");
        roleService.deleteById(sysRole.getId());
    }

    private void add() throws SystemException {
        SysRole sysRole = new SysRole();
        sysRole.setName("ROLE_ARTICLE");
        sysRole.setDescription("role article manager.");
        roleService.add(sysRole);
        Assert.assertEquals("ROLE_ARTICLE",roleService.findByRoleName("ROLE_ARTICLE").getName());
    }

    private void list() {
        List<SysRole> sysRoleList = roleService.list();
        for (SysRole sysRole : sysRoleList) {
            System.out.println(sysRole.toString());
        }
        Assert.assertEquals(2,sysRoleList.size());
    }

}
