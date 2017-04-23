package cn.itweet.common.security;

import cn.itweet.modules.admin.user.entity.SysUser;
import cn.itweet.modules.admin.user.repository.PermissionRepository;
import cn.itweet.modules.admin.user.repository.UserRepository;
import cn.itweet.modules.admin.user.entity.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo on 17/1/18.
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserRepository userRepository;

    @Autowired
    PermissionRepository permissionRepository;

    public UserDetails loadUserByUsername(String username) {
        SysUser user = userRepository.findByUsername(username);
        if (user != null) {
            List<SysPermission> permissions = permissionRepository.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
            for (SysPermission permission : permissions) {
                if (permission != null && permission.getName()!=null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}
