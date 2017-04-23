package cn.itweet.modules.admin.article.service.article;

import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.CommonUtils;
import cn.itweet.modules.admin.article.entity.Article;
import cn.itweet.modules.admin.article.entity.ArticleCategories;
import cn.itweet.modules.admin.article.entity.ArticleTag;
import cn.itweet.modules.admin.article.entity.Tag;
import cn.itweet.modules.admin.article.repository.ArticleCategoriesRepository;
import cn.itweet.modules.admin.article.repository.ArticleRepository;
import cn.itweet.modules.admin.article.repository.ArticleTagRepository;
import cn.itweet.modules.admin.article.repository.TagRepository;
import cn.itweet.modules.admin.article.utils.ArticleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by whoami on 18/04/2017.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleCategoriesRepository articleCategoriesRepository;

    @Autowired
    private ArticleTagRepository articleTagRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Page<Article> list(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article getArticleByTitle(String title) {
        return articleRepository.getArticleByTitle(title);
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleRepository.findOne(id);
    }

    @Override
    public void update(Article article) throws SystemException {
        articleRepository.save(article);
    }

    @Override
    public void deleteById(Integer id) {
        articleCategoriesRepository.deleteByArticleId(id);
        articleTagRepository.deleteByArticleId(id);
        articleRepository.delete(id);
    }

    @Override
    public void deleteByTitle(String title) {
        Article article = articleRepository.getArticleByTitle(title);
        if (article != null)
            this.deleteById(article.getId());
    }

    @Override
    public void update(Article article,String tagNames,Integer categoriesId) throws SystemException {
        List<Integer> tagIds = getTagIds(tagNames);
        if ("" == article.getTitle() || article.getTitle() == null)
            throw new SystemException("更新失败，要更新的文章名称不能为空！");
        Article oldArt = articleRepository.findOne(article.getId());
        updateArticle(article, oldArt);
        updateArticleTagInfo(tagIds, oldArt);
        updateCategoriesInfo(categoriesId, oldArt);
    }

    private List<Integer> getTagIds(String tagNames) {

        if (tagNames == null || "".equals(tagNames))
            return null;

        List<Integer> tagIds = new ArrayList<>();

        if (!tagNames.contains(",")) {
            tagCheckDB(tagNames, tagIds);
        } else {
            String[] tagName = tagNames.split(",");
            for (int i=0; i < tagName.length; i++) {
                tagCheckDB(tagName[i], tagIds);
            }
        }
        return tagIds;
    }

    private void tagCheckDB(String tagNames, List<Integer> tagIds) {
        Tag tag = tagRepository.getTagByName(tagNames);
        if (tag == null) {
            Tag t1 = tagRepository.save(new Tag(tagNames, new Date()));
            tagIds.add(t1.getId());
        } else {
            tagIds.add(tag.getId());
        }
    }

    private void updateCategoriesInfo(Integer categoriesId, Article oldArt) {
        Integer oldCategoriesId = articleCategoriesRepository.getCategoriesIdByArticleId(oldArt.getId());
        if (categoriesId != null && oldCategoriesId.equals(categoriesId))
            return;
        articleCategoriesRepository.deleteByCategoriesId(oldCategoriesId);
        articleCategoriesRepository.save(new ArticleCategories(categoriesId, oldArt.getId()));
    }

    private void updateArticleTagInfo(List<Integer> tagIds, Article oldArt) {
        List<Integer> tagIdsDB =articleTagRepository.getTagIdsByArticleId(oldArt.getId());
        if (tagIds == null && tagIdsDB.size() > 0) {
            for (Integer tagId : tagIdsDB) {
                articleTagRepository.deleteByArticleIdAndTagId(oldArt.getId(),tagId);
            }
        } else if (tagIdsDB == null && tagIds != null) {
            addArticleTag(tagIds, oldArt.getId());
        } else if (!CommonUtils.compare(tagIds,tagIdsDB)) {
            List<Integer> delTags = CommonUtils.getDeleteElements(tagIds,tagIdsDB);
            List<Integer> aggTags = CommonUtils.getAggrandizeElements(tagIds,tagIdsDB);
            if (delTags.size() > 0)
                for (Integer tagId : delTags) {
                    articleTagRepository.deleteByArticleIdAndTagId(oldArt.getId(),tagId);
                }
            if (aggTags.size() > 0)
                addArticleTag(aggTags, oldArt.getId());
        }
    }

    private void updateArticle(Article article, Article oldArt) {
        oldArt.setTitle(article.getTitle());
        oldArt.setDescription(article.getDescription());
        oldArt.setUpdateDate(new Date());
        articleRepository.save(oldArt);
    }

    @Override
    public Page<Article> searchByTitle(Pageable pageable, String title) {
        return articleRepository.searchByTitle(pageable,title);
    }

    @Override
    public Article addArticle(Article article,String tagNames,Integer categoriesId) throws SystemException {
        List<Integer> tagIds = getTagIds(tagNames);
        if ("" == article.getTitle() || article.getTitle() == null)
            throw new SystemException("添加失败，要添加的文章名称不能为空！");

        Article art = articleRepository.getArticleByTitle(article.getTitle());
        if (art != null)
            throw new SystemException("添加失败，要添加的文章名称已经存在，不可重复添加！");

        article.setCreateDate(new Date());
        Article a = articleRepository.save(article);

        addArticleCategories(categoriesId, a.getId());
        addArticleTag(tagIds, a.getId());
        return a;
    }

    private void addArticleCategories(Integer categoriesId, Integer articleId) {
        articleCategoriesRepository.save(new ArticleCategories(categoriesId, articleId));  // 默认分类: id = 0
    }

    private void addArticleTag(List<Integer> tagIds, Integer articleId) {
        if (tagIds.size() > 0) {
            List<ArticleTag> articleTagList = new ArrayList<>();
            for (Integer tagId : tagIds) {
                articleTagList.add(new ArticleTag(tagId,articleId));
            }
            articleTagRepository.save(articleTagList);
        }
    }

    @Override
    public Map<String, Article> archives() {
        List<Article> articles = (List<Article>) articleRepository.findAll();
        Map<String,Article> articleMap = new HashMap<>();
        for (Article article:articles) {
            articleMap.put(ArticleUtils.parseToTime(article.getCreateDate()),article);
        }
        return articleMap;
    }
}
