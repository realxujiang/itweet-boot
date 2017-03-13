package cn.itweet.modules.admin.user.repository;
import java.util.List;

import cn.itweet.modules.admin.user.entry.User;
import cn.itweet.modules.admin.user.entry.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
	
	@Query("select a.role from UserRole a, User b where b.userName=?1 and a.userid=b.userId")
    public List<String> findRoleByUserName(String username);

}