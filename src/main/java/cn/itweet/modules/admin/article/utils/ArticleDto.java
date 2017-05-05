package cn.itweet.modules.admin.article.utils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by whoami on 15/04/2017.
 */
public class ArticleDto {

    private Integer id;

    private String title;

    private Integer state;

    private Integer typeArticle;

    private String description;

    private String fullDescription;

    private Date createDate;

    private Date updateDate;

    private String author;

    private String coverPicture;

    public ArticleDto(Integer id, String title, Integer state, String description, String fullDescription, Date createDate, Date updateDate, String author, String coverPicture,Integer typeArticle) {
        this.id = id;
        this.title = title;
        this.state = state;
        this.description = description;
        this.fullDescription = fullDescription;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.author = author;
        this.coverPicture = coverPicture;
        this.typeArticle = typeArticle;
    }

    public ArticleDto() {
    }


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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public Integer getTypeArticle() {
        return typeArticle;
    }

    public void setTypeArticle(Integer typeArticle) {
        this.typeArticle = typeArticle;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", state=" + state +
                ", description='" + description + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", author='" + author + '\'' +
                ", coverPicture='" + coverPicture + '\'' +
                '}';
    }
}
