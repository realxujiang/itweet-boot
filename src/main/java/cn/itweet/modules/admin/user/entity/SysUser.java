package cn.itweet.modules.admin.user.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by yangyibo on 17/1/17.
 */
@Entity
@Table(name = "user")
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name="role_user",
            joinColumns=@JoinColumn(name="uid",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="rid",referencedColumnName="id")
    )
    private List<SysRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

}
