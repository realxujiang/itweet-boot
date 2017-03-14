package cn.itweet.modules.admin.user.service;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entry.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by whoami on 13/03/2017.
 */
public interface UserService {

    Optional<User> getUserById(long userid);

    User getUserByEmail(String email);

    Collection<User> getAllUsers();

    User insertUser(User user) throws SystemException;

    void updateUser(User user) throws SystemException;

    void removeUserById(Long userid);

    void deleteAll();
}
