package cn.itweet.modules.admin.user.repository;

import cn.itweet.modules.admin.user.entry.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String username);

    User getUserByEmail(String email);
}