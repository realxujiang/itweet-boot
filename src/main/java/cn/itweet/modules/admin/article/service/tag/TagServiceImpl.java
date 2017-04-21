package cn.itweet.modules.admin.article.service.tag;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Tag;
import cn.itweet.modules.admin.article.repository.ArticleTagRepository;
import cn.itweet.modules.admin.article.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by whoami on 18/04/2017.
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ArticleTagRepository articleTagRepository;

    @Override
    public Page<Tag> list(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public Tag addTag(Tag tag) throws SystemException {
        if ("" == tag.getName() || tag.getName() == null)
            throw new SystemException("添加失败，要添加的标签名称不能为空！");
        if (tagRepository.getTagByName(tag.getName()) != null)
            throw new SystemException("添加失败，要添加的标签名称已经存在！");
        return tagRepository.save(tag);
    }

    @Override
    public void deleteById(Integer id) {
        articleTagRepository.deleteByTagId(id);
        tagRepository.delete(id);
    }

    @Override
    public void update(Tag tag) throws SystemException {
        if ("" == tag.getName() || tag.getName() == null)
            throw new SystemException("更新失败，要更新的标签名称不能为空！");
        if (tagRepository.getTagByName(tag.getName()) != null)
            throw new SystemException("更新失败，要更新的标签名称已经存在！");
        Tag t = tagRepository.findOne(tag.getId());
        t.setName(tag.getName());
        t.setDate(new Date());
        tagRepository.save(t);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.getTagByName(name);
    }
}
