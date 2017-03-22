package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<SysRole, Integer> {

}