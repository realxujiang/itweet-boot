package cn.itweet.modules.admin.user.service.permission;

import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.SimplePageBuilder;
import cn.itweet.common.utils.SimpleSortBuilder;
import cn.itweet.modules.admin.user.entity.SysPermission;
import cn.itweet.modules.admin.user.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by whoami on 31/03/2017.
 */
@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Page<SysPermission> getPermissionEntry(Pageable pageable) {
        Page<SysPermission> sysPermissionPage = permissionRepository.findAll
                (SimplePageBuilder.generate(0, SimpleSortBuilder.generateSort("id")));
        return sysPermissionPage;
    }

    @Override
    public Integer refreshPermission() {
        return null;
    }

    @Override
    public List<SysPermission> getPermissionChildNodeByParentId(Integer parentId) {
        return permissionRepository.getPermissionEntityByParentId(parentId);
    }

    @Override
    public void update(SysPermission sysPermission) throws SystemException{
        if (StringUtils.isEmpty(sysPermission.getName()) && StringUtils.isEmpty(sysPermission.getPid()) && StringUtils.isEmpty(sysPermission.getUrl()))
            throw new SystemException("更新失败，要更新的权限名称,资源PID,资源URL不能为空！");

        if (sysPermission.getId() != null)
            throw new SystemException("更新失败，需要更新的资源ID不能为空！");

        SysPermission sp = permissionRepository.findOne(sysPermission.getId());
        if (!sysPermission.equals(sp)) {
            permissionRepository.save(sysPermission);
        }
    }

    @Override
    public void deleteByParmissionId(Integer parmissionId) throws SystemException{

    }
}
