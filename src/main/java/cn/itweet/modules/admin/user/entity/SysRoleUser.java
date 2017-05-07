package cn.itweet.modules.admin.user.entity;

import javax.persistence.*;

/**
 * Created by whoami on 22/03/2017.
 */
@Entity
@Table(name = "sys_role_user")
public class SysRoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "rid")
    private Integer roleId;

    @Column(name = "uid")
    private Integer userId;

    public SysRoleUser() {
    }

    public SysRoleUser(Integer roleId, Integer userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
