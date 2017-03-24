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
    @Query("delete from SysRoleUser ru where id in :ids")
    void deleteByRoleUserId(@Param("ids") List<Integer> roleUserIds);
}
