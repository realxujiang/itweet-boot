package cn.itweet.modules.admin.user.service.user;

import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.CommonUtils;
import cn.itweet.modules.admin.user.entity.SysRoleUser;
import cn.itweet.modules.admin.user.entity.SysUser;
import cn.itweet.modules.admin.user.repository.RoleUserRepository;
import cn.itweet.modules.admin.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<SysUser> list() {
        LOGGER.debug("Getting all users");
        return userRepository.findAll();
    }

    @Override
    public SysUser findById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public void add(SysUser user,List<Integer> rIds) throws SystemException {
        SysUser su = addUserInfo(user);
        addRoleUserInfo(rIds, su);
        LOGGER.debug("insert into user by username = {}",user.getUsername());
    }

    private SysUser addUserInfo(SysUser user) throws SystemException {
        if(userRepository.findByUsername(user.getUsername()) != null)
            throw new SystemException("你要添加的用户名已经存在，不能重复添加！");

        return userRepository.save(user);
    }

    private void addRoleUserInfo(List<Integer> rIds, SysUser su) {
        List<SysRoleUser> ruList = new ArrayList<>();
        for (int i=0; i < rIds.size(); i++) {
            SysRoleUser ru = new SysRoleUser();
            ru.setRoleId(rIds.get(i));
            ru.setUserId(su.getId());
            ruList.add(ru);
        }
        roleUserRepository.save(ruList);
    }

    @Override
    public void update(SysUser user,List<Integer> rIds) throws SystemException {
        SysUser u1 = userRepository.findOne(user.getId());
        if (u1 != null) {
            updateUserAndUserRoles(user, rIds, u1);
        }
        LOGGER.debug("update user by username = {}", u1.getUsername());
    }

    @Override
    public void update(SysUser user) throws SystemException {
        userRepository.save(user);
    }

    private void updateUserAndUserRoles(SysUser user, List<Integer> rIds, SysUser u1) {
        List<Integer> roleUserList = roleUserRepository.getRoleIdsByUid(u1.getId());
        System.out.println("roleUserList database --> : " + roleUserList.toString());
        if (roleUserList.toString().equals(rIds.toString())) {
            updateUser(user, u1);
        } else {
            updateRoleUser(rIds, u1, roleUserList);
            updateUser(user, u1);
        }
    }

    private void updateRoleUser(List<Integer> rIds, SysUser u1, List<Integer> roleUserList) {
        System.out.println("rids: "+rIds.toString());
        if (!CommonUtils.compare(rIds,roleUserList)) {
            List<Integer> deleteElems = CommonUtils.getDeleteElements(rIds, roleUserList);
            List<Integer> aggElems = CommonUtils.getAggrandizeElements(rIds, roleUserList);

            if (aggElems.size() != 0) {
                for (int i = 0; i < aggElems.size(); i++) {
                    System.out.println("aggElems: "+aggElems.toString());
                    SysRoleUser ru = new SysRoleUser();
                    ru.setUserId(u1.getId());
                    ru.setRoleId(aggElems.get(i));
                    roleUserRepository.save(ru);
                }
            }

            if (deleteElems.size() != 0) {
                System.out.println("deleteElems: "+deleteElems.toString());
                for (int i = 0; i < deleteElems.size(); i++) {
                    List<Integer> roleUserIds = roleUserRepository.getRoleUserIdsByRoleIdAndUserId(deleteElems.get(i),u1.getId());
                    roleUserRepository.deleteByRoleUserIds(roleUserIds);
                }
            }
        }
    }



    private void updateUser(SysUser user, SysUser u1) {
        SysUser u2 = new SysUser();
        if (!u1.getUsername().equals(user.getUsername()) || !u1.getEmail().equals(user.getEmail())) {
            u2.setId(u1.getId());
            u2.setPassword(u1.getPassword());
            u2.setUsername(user.getUsername());
            u2.setEmail(user.getEmail());
            userRepository.save(u2);
        }
    }

    @Override
    public void deleteById(Integer uid) throws SystemException {
        SysUser u = userRepository.findOne(uid);
        if (u != null && u.getUsername() != "admin") {
            List<Integer> roleUserIds = roleUserRepository.getRoleUserIdsByUid(uid);
            roleUserRepository.deleteByRoleUserIds(roleUserIds);
            userRepository.delete(uid);
        } else {
            throw new SystemException("你要删除的用户是系统默认超级管理员，不能删除！");
        }
        LOGGER.debug("delete user by username = {}",u.getUsername());
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("delete all users by {}","UserServiceImpl");
        userRepository.deleteAll();
    }

}
