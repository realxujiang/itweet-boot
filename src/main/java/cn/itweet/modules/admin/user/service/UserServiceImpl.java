package cn.itweet.modules.admin.user.service;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entry.SysUser;
import cn.itweet.modules.admin.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<SysUser> getUserById(long userid) {
        LOGGER.debug("Getting user={}", userid);
        return Optional.ofNullable(userRepository.findOne(userid));
    }

    @Override
    public Collection<SysUser> getAllUsers() {
        LOGGER.debug("Getting all users");
        return (Collection<SysUser>) userRepository.findAll();
    }

    @Override
    public SysUser insertUser(SysUser user) throws SystemException {
        LOGGER.debug("insert into user by username = {}","none");

        return userRepository.save(user);
    }

    @Override
    public void updateUser(SysUser user) throws SystemException{

        LOGGER.debug("update user by username = {}",user.getUsername());

        userRepository.save(user);
    }

    @Override
    public void removeUserById(Long id) {

        //LOGGER.debug("delete user by userid = {}",userRepository.findOne(id).getEmail());

        userRepository.delete(id);
    }

    @Override
    public void deleteAll() {

        LOGGER.debug("delete all users by {}","UserService");

        userRepository.deleteAll();
    }

}
