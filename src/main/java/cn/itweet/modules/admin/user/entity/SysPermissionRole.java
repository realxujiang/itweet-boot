package cn.itweet.modules.admin.user.entity;

import javax.persistence.*;

/**
 * Created by whoami on 22/03/2017.
 */
@Entity
@Table(name = "sys_permission_role")
public class SysPermissionRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "rid")
    private Integer roleId;

    @Column(name = "permission_id")
    private Integer permissionId;

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

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
