package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entry.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by yangyibo on 17/1/20.
 */
public interface PermissionRepository extends JpaRepository<SysPermission,Long>{

    List<SysPermission> findAll();

    @Query(value = "select p.* from User u LEFT JOIN role_user sru on u.id= sru.uid LEFT JOIN Role r on sru.rid=r.id LEFT JOIN permission_role spr on spr.rid=r.id LEFT JOIN permission p on p.id =spr.permission_id where u.id=?1",nativeQuery = true)
    List<SysPermission> findByAdminUserId(int userId);
}
