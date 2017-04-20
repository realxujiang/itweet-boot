package cn.itweet.modules.admin.article.repository;

import cn.itweet.modules.admin.article.entity.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by whoami on 16/04/2017.
 */
@Repository
@Transactional
public interface TagRepository extends PagingAndSortingRepository<Tag,Integer> {

    @Query("from Tag where name=?1")
    Tag getTagByName(String name);
}
