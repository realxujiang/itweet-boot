package cn.itweet.modules.admin.user.entry;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yangyibo on 17/1/17.
 */
@Entity
@Table(name = "role")
public class SysRole implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name="permission_role",
            joinColumns=@JoinColumn(name="rid",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="permission_id",referencedColumnName="id")
    )
    List<SysPermission> permissions;

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

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}
