package cn.itweet.modules.admin.user.entity;

import javax.persistence.*;

/**
 * Created by yangyibo on 17/1/20.
 */
@Entity
@Table(name = "sys_permission")
public class SysPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //权限名称
    private String name;

    //权限描述
    private String descritpion;

    //授权链接
    private String url;

    //父节点id
    private Integer pid;

    //父节点的 - 权限名称
    private String pname;

    //权限的操作，默认值：add开头表示添加，update表示更新，list开头表示列表，delete开头表示删除,manager表示管理
    private String operation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descritpion='" + descritpion + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
