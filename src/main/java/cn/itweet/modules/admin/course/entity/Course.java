package cn.itweet.modules.admin.course.entity;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.util.Date;

/**
 * Created by whoami on 09/05/2017.
 */
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    /**
     * 教程描述
     */
    private String description;

    /**
     * 教程分类
     */
    private String classify;

    /**
     * 教程介绍
     */
    @Column(name = "content",columnDefinition="TEXT")
    private String content;

    private String work;

    /**
     * 教程标签
     */
    private String tag;

    @Column(name = "create_date")
    private Date createDate;

    /**
     * 封面图片
     */
    @Column(name = "cover_picture")
    private String coverPicture;

    /**
     * 轮播图片1
     */
    @Column(name = "slide_one")
    private String slideOne;

    /**
     * 轮播图片2
     */
    @Column(name = "slide_two")
    private String slideTwo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public String getSlideOne() {
        return slideOne;
    }

    public void setSlideOne(String slideOne) {
        this.slideOne = slideOne;
    }

    public String getSlideTwo() {
        return slideTwo;
    }

    public void setSlideTwo(String slideTwo) {
        this.slideTwo = slideTwo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
