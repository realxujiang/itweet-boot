package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<SysUser,Integer> {

    @Query(value = "select u.*,r.name from Sys_User u LEFT JOIN sys_role_user sru on u.id= sru.uid LEFT JOIN Sys_Role r on sru.rid=r.id where username=?1",nativeQuery = true)
    SysUser findByUserName(String username);

    @Query(value = "from SysUser where username=?1")
    SysUser findByUsername(String username);

    @Query(value = "from SysUser where email=?1")
    SysUser findByEmail(String email);
}
