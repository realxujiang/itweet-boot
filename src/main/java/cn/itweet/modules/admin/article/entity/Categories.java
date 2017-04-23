package cn.itweet.modules.admin.article.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by whoami on 15/04/2017.
 */
@Entity
@Table(name = "categories")
public class Categories {

    /**
     * 默认分类ID为0，即default
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Date date;

    public Categories() {

    }

    public Categories(String name, Date date) {
        this.name = name;
        this.date = date;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
