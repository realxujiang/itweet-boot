package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entity.SysPermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whoami on 22/03/2017.
 */
@Repository
@Transactional //因为默认是readOnly=true的，这里必须自己进行声明
public interface PermissionRoleRepository extends JpaRepository<SysPermissionRole,Integer> {

    @Query("delete from SysPermissionRole where roleId=?1")
    @Modifying //说明该操作是修改类型操作，删除或者修改
    void deleteByRoleId(Integer roleId);

    @Query(value = "delete from Sys_Permission_Role where rid=?1 and permission_id=?2",nativeQuery = true)
    @Modifying //说明该操作是修改类型操作，删除或者修改
    void deleteByRoleIdAndPermissionId(Integer rid,Integer permission_id);

    @Query(value = "select permission_id from sys_permission_role where rid=?1",nativeQuery = true)
    List<Integer> getPermissionRoleIdsByRoleId(Integer rid);

    @Query(value = "delete from Sys_Permission_Role where permission_id=?1",nativeQuery = true)
    @Modifying
    void deleteByPermissionId(Integer permission_id);
}
