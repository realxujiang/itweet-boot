package cn.itweet.modules.admin.article.repository;

import cn.itweet.common.repository.BaseRepository;
import cn.itweet.modules.admin.article.entity.Categories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whoami on 16/04/2017.
 */
@Repository
@Transactional
public interface CategoriesRepository extends BaseRepository<Categories,Integer> {

    @Query("from Categories where name=?1")
    Categories getCategoriesByName(String name);

    @Query("select c from Categories c where c.name like %:name%")
    List<Categories> selectByName(@Param("name") String name);
}
