package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entity.SysPermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whoami on 22/03/2017.
 */
@Repository
@Transactional
public interface PermissionRoleRepository extends JpaRepository<SysPermissionRole,Integer> {

    @Query("delete from SysPermissionRole where roleId=?1")
    void deleteByRoleId(Integer roleId);

    @Query("delete from SysPermissionRole where roleId=?1 and permissionId=?2")
    void deleteByRoleIdAndPermissionId(Integer roleId,Integer permissionId);

    @Query(value = "select permission_id from sys_permission_role where rid=?1",nativeQuery = true)
    List<Integer> getPermissionRoleIdsByRoleId(Integer rid);


}
