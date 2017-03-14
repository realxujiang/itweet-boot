package cn.itweet.modules.admin.licence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 说明：
 * 包名：cn.itweet.modules.admin.licence
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
@Entity
@Table(name = "r_licence")
public class Licence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="l_id")
    private int id;

    @Column(name = "l_company")
    private String company;

    @Column(name = "l_project")
    private String project;

    @Column(name = "l_email")
    private String email;

    @Column(name = "l_products")
    private String products;

    @Column(name = "l_node")
    private int node;

    @Column(name = "l_date")
    private Date date;

    @Column(name = "l_code")
    private String code;

    @Column(name = "l_version")
    private int version;

    @Column(name = "l_status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
