package cn.itweet.modules.admin.user.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yangyibo on 17/1/17.
 */
@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

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
}
