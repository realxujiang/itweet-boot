package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entity.SysRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<SysRole, Long> {

}