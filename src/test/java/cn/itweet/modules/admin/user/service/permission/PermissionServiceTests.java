package cn.itweet.modules.admin.user.service.permission;

import cn.itweet.ItweetBootApplication;
import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entity.SysPermission;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by whoami on 10/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItweetBootApplication.class)
public class PermissionServiceTests {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void test() {
        // refreshPermissionTest();
        // getPermissionChildNodeByParentIdTest();

        //listTest();

        //updateTest();

        //DeleteByParmissionIdTest();
    }

    private void updateTest() {
        SysPermission sysPermission1 = permissionService.findByParmissionId(40);
        sysPermission1.setName("测试权限修改Name信息");
        try {
            permissionService.update(sysPermission1);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        SysPermission sysPermission2 = permissionService.findByParmissionId(40);
        Assert.assertEquals("测试权限修改Name信息",sysPermission2.getName());
    }

    private void DeleteByParmissionIdTest() {
        try {
            permissionService.deleteByParmissionId(40);
            SysPermission sysPermission = permissionService.findByParmissionId(40);
            Assert.assertNull(sysPermission);
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }

    private void listTest() {
        Page<SysPermission> sysPermissionPage = permissionService.list(0);
        System.out.println("JJJJ"+sysPermissionPage.getContent().toString());
        sysPermissionPage.getTotalPages();
        //Assert.assertEquals(10,sysPermissionPage.getSize());
    }

    private void getPermissionChildNodeByParentIdTest() {
        List<SysPermission> sysPermissionList = permissionService.getPermissionChildNodeByParentId(0);
        Assert.assertEquals(3,sysPermissionList.size());

        List<SysPermission> userSysPermissionList = permissionService.getPermissionChildNodeByParentId(40);
        Assert.assertEquals(5,userSysPermissionList.size());
    }

    private void refreshPermissionTest() {
        try {
            Integer flag = permissionService.refreshPermission();
            if (flag == 0) {
                System.out.println("权限初始化成功");
            } else {
                System.out.println("权限初始化失败");
            }
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }

}
