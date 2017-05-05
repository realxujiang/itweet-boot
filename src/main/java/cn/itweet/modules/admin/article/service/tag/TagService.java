package cn.itweet.modules.admin.article.service.tag;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by whoami on 17/04/2017.
 */
public interface TagService {

    Page<Tag> list(Integer page);

    Page<Tag> selectByName(Integer page, String name);

    Tag addTag(Tag tag) throws SystemException;

    void deleteById(Integer id);

    void update(Tag tag) throws SystemException;

    Tag getTagByName(String name);

    String findTagNamesByArticleId(Integer id);
}
