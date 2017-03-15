package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entry.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<SysUser,Long> {

    @Query(value = "select u.*,r.name from User u LEFT JOIN role_user sru on u.id= sru.uid LEFT JOIN Role r on sru.rid=r.id where username=?1",nativeQuery = true)
    SysUser findByUserName(String username);

}
