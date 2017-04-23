package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<SysRole, Integer> {

    @Query("from SysRole where name=?1")
    SysRole findByRoleName(String roleName);

}