package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entity.SysRoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by whoami on 22/03/2017.
 */
@Repository
public interface RoleUserRepository extends JpaRepository<SysRoleUser,Integer> {
    @Query(value = "select id from SysRoleUser where uid=?1")
    List<Integer> getRoleUserIdsByUid(Integer uid);

    @Query("delete from SysRoleUser ru where id in :ids")
    void deleteByRoleUserId(@Param("ids") List<Integer> roleUserIds);
}
