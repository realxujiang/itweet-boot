package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entity.SysPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whoami on 17/1/20.
 */
@Repository
@Transactional
public interface PermissionRepository extends PagingAndSortingRepository<SysPermission,Integer> {

    /**
     * 获取所有的权限信息
     * @return
     */
    List<SysPermission> findAll();

    /**
     * 通过超级用户ID获取权限控制列表
     * @param userId
     * @return
     */
    @Query(value = "select distinct p.* from Sys_User u LEFT JOIN sys_role_user sru on u.id= sru.uid LEFT JOIN Sys_Role r on sru.rid=r.id LEFT JOIN sys_permission_role spr on spr.rid=r.id LEFT JOIN Sys_Permission p on p.id =spr.permission_id where u.id=?1",nativeQuery = true)
    List<SysPermission> findByAdminUserId(int userId);

    @Query(nativeQuery = true,value = "select * from sys_permission where pid=?1")
    List<SysPermission> getPermissionEntityByParentId(Integer parentId);

    @Query("delete from SysPermission where id=?1")
    @Modifying
    void deletePermissionByPermissionId(Integer permissionId);

    @Query("select id from SysPermission where name=?1")
    Integer findPidByPname(String pname);

    @Query("select distinct id from SysPermission")
    List<Integer> getPermissionIds();

}
