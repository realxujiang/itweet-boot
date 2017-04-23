package cn.itweet.modules.admin.document.entiry;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by whoami on 22/04/2017.
 */
@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String filename;

    @Column(name = "rule_filename")
    private String ruleFilename;

    private String type;

    private Date date;

    /**
     * 图片所属栏目
     */
    private String columnd;

    public String getColumnd() {
        return columnd;
    }

    public void setColumnd(String columnd) {
        this.columnd = columnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getRuleFilename() {
        return ruleFilename;
    }

    public void setRuleFilename(String ruleFilename) {
        this.ruleFilename = ruleFilename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", ruleFilename='" + ruleFilename + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
