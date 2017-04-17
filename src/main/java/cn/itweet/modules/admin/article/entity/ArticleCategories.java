package cn.itweet.modules.admin.article.entity;

import javax.persistence.*;

/**
 * Created by whoami on 15/04/2017.
 */
@Entity
@Table(name = "article_categories")
public class ArticleCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "categories_id")
    private Integer categoriesId;

    @Column(name = "article_id")
    private Integer articleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Integer categoriesId) {
        this.categoriesId = categoriesId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
