package cn.itweet.modules.admin.user.service;

import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.CommonUtils;
import cn.itweet.modules.admin.user.entity.SysRoleUser;
import cn.itweet.modules.admin.user.entity.SysUser;
import cn.itweet.modules.admin.user.repository.RoleRepository;
import cn.itweet.modules.admin.user.repository.RoleUserRepository;
import cn.itweet.modules.admin.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by whoami on 13/03/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleUserRepository roleUserRepository;

    @Override
    public SysUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Collection<SysUser> list() {
        LOGGER.debug("Getting all users");
        return (Collection<SysUser>) userRepository.findAll();
    }

    @Override
    public SysUser add(SysUser user) throws SystemException {
        LOGGER.debug("insert into user by username = {}","none");
        return userRepository.save(user);
    }

    @Override
    public void update(SysUser user,List<Integer> rIds) throws SystemException {
        LOGGER.debug("update user by username = {}", user.getUsername());
        SysUser u1 = userRepository.findOne(user.getId());
        SysUser u2 = new SysUser();
        if (u1 != null) {
            updateUserAndUserRoles(user, rIds, u1, u2);
        }
    }

    private void updateUserAndUserRoles(SysUser user, List<Integer> rIds, SysUser u1, SysUser u2) {
        List<Integer> roleUserList = roleUserRepository.getRoleUserIdsByUid(u1.getId());
        if (roleUserList.equals(rIds)) {
            updateUser(user, u1, u2);
        } else {
            updateRoleUser(rIds, u1, roleUserList);
            updateUser(user, u1, u2);
        }
    }

    private void updateRoleUser(List<Integer> rIds, SysUser u1, List<Integer> roleUserList) {
        List<Integer> aggElems = CommonUtils.getAggrandizeElements(rIds,roleUserList);
        List<Integer> deleteElems = CommonUtils.getDeleteElements(rIds,roleUserList);
        if (aggElems != null ) {
            for (int i=0; i<aggElems.size();i++) {
                SysRoleUser ru = new SysRoleUser();
                ru.setUserId(u1.getId());
                ru.setRoleId(aggElems.get(i));
                roleUserRepository.save(ru);
            }
        } else if(deleteElems != null) {
            for (int i=0; i<deleteElems.size();i++) {
                roleUserRepository.delete(deleteElems.get(i));
            }
        }
    }

    private void updateUser(SysUser user, SysUser u1, SysUser u2) {
        u2.setId(u1.getId());
        u2.setUsername(user.getUsername());
        u2.setPassword(u1.getPassword());
        userRepository.save(u2);
    }

    @Override
    public void deleteById(Integer uid) {
        SysUser u = userRepository.findOne(uid);
        if (u != null && u.getUsername() != "admin") {
            List<Integer> roleUserIds = roleUserRepository.getRoleUserIdsByUid(uid);
            roleUserRepository.deleteByRoleUserId(roleUserIds);
            userRepository.delete(uid);
        }
        LOGGER.debug("delete user by username = {}",u.getUsername());
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("delete all users by {}","UserService");

        userRepository.deleteAll();
    }

}
