package cn.itweet.modules.admin.article.utils;

/**
 * Created by whoami on 05/05/2017.
 */
public class CategoriesDto {

    private Integer id;

    private String name;

    private Integer count;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CategoriesDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
