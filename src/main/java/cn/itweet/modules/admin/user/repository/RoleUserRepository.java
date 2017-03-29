package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entity.SysRoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whoami on 22/03/2017.
 */
@Repository
@Transactional
public interface RoleUserRepository extends JpaRepository<SysRoleUser,Integer> {
    @Query(value = "select id from SysRoleUser where uid=?1")
    List<Integer> getRoleUserIdsByUid(Integer uid);

    @Query(value = "select roleId from SysRoleUser where uid=?1")
    List<Integer> getRoleIdsByUid(Integer uid);

    @Modifying
    @Query("delete from SysRoleUser where id in :ids")
    void deleteByRoleUserIds(@Param("ids") List<Integer> roleUserIds);

    @Query(value = "delete from Sys_Role_User where rid=?1",nativeQuery = true)
    @Modifying
    void deleteByRoleId(Integer rid);

    @Query(value = "select id from sys_role_user where rid=?1 and uid=?2",nativeQuery = true)
    List<Integer> getRoleUserIdsByRoleIdAndUserId(Integer rid,Integer uid);

    @Query(value = "select id from sys_role_user where rid=?1",nativeQuery = true)
    List<Integer> getRoleUserIdsyRoleId(Integer rid);
}
