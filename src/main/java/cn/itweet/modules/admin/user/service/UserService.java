package cn.itweet.modules.admin.user.service;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entity.SysUser;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by whoami on 13/03/2017.
 */
public interface UserService {

    Optional<SysUser> getUserById(long userid);

    Collection<SysUser> getAllUsers();

    SysUser insertUser(SysUser user) throws SystemException;

    void updateUser(SysUser user) throws SystemException;

    void removeUserById(Long userid);

    void deleteAll();
}
