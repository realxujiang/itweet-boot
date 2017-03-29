package cn.itweet.modules.admin.user.service.role;

import cn.itweet.ItweetBootApplication;
import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entity.SysPermissionRole;
import cn.itweet.modules.admin.user.entity.SysRole;
import cn.itweet.modules.admin.user.repository.PermissionRoleRepository;
import cn.itweet.modules.admin.user.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
        addTest();

        updateTest();

        findTest();

        listTest();

        deleteByIdTest();

        setAuthorizationTest();
    }

    private void setAuthorizationTest() {
        List<Integer> permissionRoleList = new ArrayList<>();
        permissionRoleList.add(1);
        roleService.setAuthorization(2,permissionRoleList);
    }

    private void findTest() {
        SysRole sysRole = roleService.findByRoleName("ROLE_ARTICLE_UPDATE");
        Assert.assertNotNull(roleService.findById(sysRole.getId()));
    }

    private void updateTest() throws SystemException {
        SysRole sysRole = roleService.findByRoleName("ROLE_ARTICLE");
        sysRole.setName("ROLE_ARTICLE_UPDATE");
        sysRole.setDescription("Role article manager.");
        roleService.update(sysRole);
    }


    private void deleteByIdTest() throws SystemException {
        SysRole sysRole = roleService.findByRoleName("ROLE_ARTICLE_UPDATE");
        roleService.deleteById(sysRole.getId());
    }

    private void addTest() throws SystemException {
        SysRole sysRole = new SysRole();
        sysRole.setName("ROLE_ARTICLE");
        sysRole.setDescription("role article manager.");
        roleService.add(sysRole);
        Assert.assertEquals("ROLE_ARTICLE",roleService.findByRoleName("ROLE_ARTICLE").getName());
    }

    private void listTest() {
        SysRole sysRoleList = roleService.findByRoleName("ROLE_ARTICLE_UPDATE");
        Assert.assertNotNull(sysRoleList);
    }

}
