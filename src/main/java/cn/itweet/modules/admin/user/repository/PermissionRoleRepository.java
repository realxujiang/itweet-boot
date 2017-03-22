package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entity.SysPermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by whoami on 22/03/2017.
 */
@Repository
public interface PermissionRoleRepository extends JpaRepository<SysPermissionRole,Integer> {

}
