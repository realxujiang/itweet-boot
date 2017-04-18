package cn.itweet.common.utils;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.system.RootController;
import cn.itweet.modules.admin.user.entity.SysPermission;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by whoami on 22/03/2017.
 */
public class CommonUtilsTests {

    @Test
    public void testRootMenu() {
        RootMenu(RootController.class);
    }

    private void RootMenu(Class c) {
        String path = null;
        if(c.isAnnotationPresent(RequestMapping.class)) {
            path = ((RequestMapping)c.getAnnotation(RequestMapping.class)).value()[0];
        }
        Method[] ms = c.getDeclaredMethods();
        List<SysPermission> list = new ArrayList<>();
        SysPermission mr = null;
        for (Method m : ms) {
            //添加left菜单
            if (m.isAnnotationPresent(RootMenu.class)) {
                String url = null;
                if (m.isAnnotationPresent(GetMapping.class)) {
                    url = path + ((GetMapping)m.getAnnotation(GetMapping.class)).value()[0];
                }
                if (m.isAnnotationPresent(PostMapping.class)) {
                    url = path + ((PostMapping)m.getAnnotation(PostMapping.class)).value()[0];
                }
                if (m.isAnnotationPresent(PutMapping.class)) {
                    url = path + ((PutMapping)m.getAnnotation(PutMapping.class)).value()[0];
                }
                if (m.isAnnotationPresent(DeleteMapping.class)) {
                    url = path + ((DeleteMapping)m.getAnnotation(DeleteMapping.class)).value()[0];
                }
                RootMenu nm = m.getAnnotation(RootMenu.class);
                mr = new SysPermission();
                mr.setPname(nm.pname());
                mr.setPid(Integer.valueOf(nm.pid()));
                mr.setUrl(nm.url());
                mr.setDescritpion(nm.descritpion());
                mr.setName(nm.name());
                mr.setOperation(nm.operation());
                list.add(mr);
            }
        }
        if (list.size() <= 0)
            new SystemException("初始化权限失败,需要初始化的权限集合不能为空!");
        System.out.println(list.toString());
    }

    @Test
    public void getDeleteElementsTest() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(4);

        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(7);
        b.add(6);

        List<Integer> list = CommonUtils.getDeleteElements(a,b);
        System.out.println(list.toString());
        Assert.assertEquals(2,list.size());
    }

    @Test
    public void getAggrandizeElements() {
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(7);
        a.add(6);
        a.add(8);
        a.add(9);

        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(7);
        b.add(6);

        List<Integer> list = CommonUtils.getAggrandizeElements(a,b);
        System.out.println(list.toString());
        Assert.assertEquals(2,list.size());
    }

}
