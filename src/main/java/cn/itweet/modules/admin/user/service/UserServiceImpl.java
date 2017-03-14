package cn.itweet.modules.admin.user.service;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entry.User;
import cn.itweet.modules.admin.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by whoami on 13/03/2017.
 */
@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserById(long userid) {
        LOGGER.debug("Getting user={}", userid);
        return Optional.ofNullable(userRepository.findOne(userid));
    }

    @Override
    public User getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return userRepository.getUserByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        LOGGER.debug("Getting all users");
        return (Collection<User>) userRepository.findAll();
    }

    @Override
    public User insertUser(User user) throws SystemException {
        User u1 = userRepository.findByUserName(user.getUserName());
        if (u1 != null) throw new SystemException("该用户已经存在不能重复添加！");
        User u2 = new User();
        u2.setEmail(user.getEmail());
        u2.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        u2.setUserName(user.getUserName());
        u2.setEnabled(user.getEnabled());

        LOGGER.debug("insert into user by username = {}",u2.getEmail());

        return userRepository.save(u2);
    }

    @Override
    public void updateUser(User user) throws SystemException{
        User u1 = userRepository.findOne(user.getUserid());
        if (u1 == null) throw new SystemException("要更新的用户不存在，请确认!");
        User u2 = new User();
        u2.setEmail(user.getEmail());
        u2.setPassword(u1.getPassword());
        u2.setUserName(user.getUserName());
        u2.setEnabled(user.getEnabled());

        LOGGER.debug("update user by username = {}",user.getUserName());

        userRepository.save(u2);
    }

    @Override
    public void removeUserById(Long id) {

        LOGGER.debug("delete user by userid = {}",userRepository.findOne(id).getEmail());

        userRepository.delete(id);
    }

    @Override
    public void deleteAll() {

        LOGGER.debug("delete all users by {}","UserService");

        userRepository.deleteAll();
    }

}
