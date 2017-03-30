package cn.itweet.modules.admin.user.service.permission;

import cn.itweet.common.utils.SimplePageBuilder;
import cn.itweet.common.utils.SimpleSortBuilder;
import cn.itweet.modules.admin.user.entity.SysPermission;
import cn.itweet.modules.admin.user.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public void update(SysPermission sysPermission) {

    }

    @Override
    public void deleteById(Integer parmissionId) {

    }
}
