package cn.itweet.modules.admin.user.repository;
import java.util.List;

import cn.itweet.modules.admin.user.entry.SysRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<SysRole, Long> {

}