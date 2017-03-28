package cn.itweet.modules.admin.user.service.role;

import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.CommonUtils;
import cn.itweet.modules.admin.user.entity.SysPermissionRole;
import cn.itweet.modules.admin.user.entity.SysRole;
import cn.itweet.modules.admin.user.repository.PermissionRepository;
import cn.itweet.modules.admin.user.repository.PermissionRoleRepository;
import cn.itweet.modules.admin.user.repository.RoleRepository;
import cn.itweet.modules.admin.user.repository.RoleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by whoami on 26/03/2017.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRoleRepository permissionRoleRepository;

    @Autowired
    private RoleUserRepository roleUserRepository;

    @Override
    public List<SysRole> list() {
        return roleRepository.findAll();
    }

    @Override
    public void update(SysRole role) {
        SysRole sysRole = roleRepository.findOne(role.getId());
        if (role != null && sysRole != null) {
            roleRepository.save(role);
        }
    }

    @Override
    public SysRole add(SysRole role) throws SystemException {
        SysRole sysRole = roleRepository.findByRoleName(role.getName());
        if(role != null && sysRole == null) {
            return roleRepository.save(role);
        } else {
            throw new SystemException("角色名称已经存在，不可重复添加！");
        }
    }

    @Override
    public void deleteById(Integer id) {
        SysRole sysRole = roleRepository.findOne(id);
        if (sysRole != null) {
            roleUserRepository.deleteByRoleId(id);
            permissionRoleRepository.deleteByRoleId(id);
            roleRepository.delete(id);
        }
    }

    @Override
    public SysRole findById(Integer id) {
        return roleRepository.findOne(id);
    }

    @Override
    public SysRole findByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }

    @Override
    public void roleAuthorization(Integer rid, List<Integer> perissionIds) {
        List<Integer> dbPerissionIds = permissionRoleRepository.getPermissionRoleIdsByRoleId(rid);
        List<Integer> delElems = CommonUtils.getDeleteElements(perissionIds,dbPerissionIds);
        List<Integer> aggElems = CommonUtils.getAggrandizeElements(perissionIds,dbPerissionIds);

        if (delElems != null) {
            for (Integer perissionId : delElems) {
                permissionRoleRepository.deleteByRoleIdAndPermissionId(rid,perissionId);
            }
        }

        if (aggElems != null) {
            for (Integer perissionId : aggElems) {
                SysPermissionRole sysPermissionRole = new SysPermissionRole();
                sysPermissionRole.setRoleId(rid);
                sysPermissionRole.setPermissionId(perissionId);
                permissionRoleRepository.save(sysPermissionRole);
            }
        }
    }
}
