package cn.itweet.modules.admin.user.service.permission;

import cn.itweet.common.config.ItweetProperties;
import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.*;
import cn.itweet.modules.admin.system.RootController;
import cn.itweet.modules.admin.user.entity.*;
import cn.itweet.modules.admin.user.repository.*;
import cn.itweet.modules.admin.user.service.user.UserServiceImpl;
import cn.itweet.modules.admin.user.web.RoleController;
import cn.itweet.modules.admin.user.web.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by whoami on 31/03/2017.
 */
@Service
public class PermissionServiceImpl implements PermissionService{

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionServiceImpl.class);


    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionRoleRepository permissionRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleUserRepository roleUserRepository;

    @Autowired
    private ItweetProperties itweetProperties;

    @Override
    public Page<SysPermission> list(Integer page) {
        return permissionRepository.findAll(SimplePageBuilder.generate(page,itweetProperties.getPagSize(), SimpleSortBuilder.generateSort("id")));
    }

    @Override
    public Integer refreshPermission() throws SystemException{
        try {
            RootMenu(RootController.class);
            addLeftMenu(UserController.class);
            addLeftMenu(RoleController.class);
            initRolePermission();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("权限初始化失败!");
            return 1;
        }
        LOGGER.info("权限初始化成功!");
        return 0;
    }

    /**
     * 初始化角色资源表
     */
    private void initRolePermission() {
        List<Integer> permissionIds = permissionRepository.getPermissionIds();
        SysRole sysRole = roleRepository.findByRoleName("ROLE_ADMIN");
        SysUser sysUser = userRepository.findByUsername("admin");

        if (sysRole == null && sysUser == null) {
            SysRole sr = roleRepository.save(new SysRole("ROLE_ADMIN","Role admin manager"));
            SysUser su = userRepository.save(new SysUser("admin","admin@itweet.cn","123456"));
            roleUserRepository.save(new SysRoleUser(sr.getId(),su.getId()));
            savePermissionRole(permissionIds, sr);
        } else {
            savePermissionRole(permissionIds, sysRole);
        }
    }

    private void savePermissionRole(List<Integer> permissionIds, SysRole sr) {
        SysPermissionRole sysPermissionRole = null;
        permissionRoleRepository.deleteAll();
        for (Integer permissionId : permissionIds) {
            sysPermissionRole = new SysPermissionRole();
            sysPermissionRole.setRoleId(sr.getId());
            sysPermissionRole.setPermissionId(permissionId);
            permissionRoleRepository.save(sysPermissionRole);
        }
    }

    /**
     * 左边根菜单，初始化到权限资源表
     * @param c
     * @return
     */
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
        permissionRepository.save(list);
    }

    /**
     * 左边栏菜单初始化到权限资源表
     * @param c
     * @return
     */
    private void addLeftMenu(Class c) {
        String path = null;
        if(c.isAnnotationPresent(RequestMapping.class)) {
            path = ((RequestMapping)c.getAnnotation(RequestMapping.class)).value()[0];
        }
        Method[] ms = c.getDeclaredMethods();
        List<SysPermission> list = new ArrayList<>();
        SysPermission mr = null;
        for (Method m : ms) {
            //添加left菜单
            if (m.isAnnotationPresent(LeftMenu.class)) {
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
                LeftMenu nm = m.getAnnotation(LeftMenu.class);
                mr = new SysPermission();
                mr.setPname(nm.pname());
                mr.setPid(permissionRepository.findPidByPname(nm.pname()));
                mr.setUrl(nm.url());
                mr.setDescritpion(nm.descritpion());
                mr.setName(nm.name());
                mr.setOperation(nm.operation());
                list.add(mr);
            }
        }
        if (list.size() <= 0)
            new SystemException("初始化权限失败,需要初始化的权限集合不能为空!");
        permissionRepository.save(list);
    }

    @Override
    public List<SysPermission> getPermissionChildNodeByParentId(Integer parentId) {
        return permissionRepository.getPermissionEntityByParentId(parentId);
    }

    @Override
    public void update(SysPermission sysPermission) throws SystemException{
        if (StringUtils.isEmpty(sysPermission.getName()) && StringUtils.isEmpty(sysPermission.getPid()) && StringUtils.isEmpty(sysPermission.getUrl()))
            throw new SystemException("更新失败，要更新的权限名称,资源PID,资源URL不能为空！");

        if (sysPermission.getId() == null)
            throw new SystemException("更新失败，需要更新的资源ID不能为空！");

        SysPermission sp = permissionRepository.findOne(sysPermission.getId());
        if (!sysPermission.equals(sp)) {
            permissionRepository.save(sysPermission);
        }
    }

    @Override
    public void deleteByParmissionId(Integer permissionId) throws SystemException{
        if (permissionId != null) {
            permissionRepository.deletePermissionByPermissionId(permissionId);
            permissionRoleRepository.deleteByPermissionId(permissionId);
        }
    }

    @Override
    public SysPermission findByParmissionId(Integer parmissionId) {
        return permissionRepository.findOne(parmissionId);
    }
}
