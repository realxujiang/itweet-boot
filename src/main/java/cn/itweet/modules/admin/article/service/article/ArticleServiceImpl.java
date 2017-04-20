package cn.itweet.modules.admin.article.service.article;

import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.CommonUtils;
import cn.itweet.modules.admin.article.entity.Article;
import cn.itweet.modules.admin.article.entity.ArticleCategories;
import cn.itweet.modules.admin.article.entity.ArticleTag;
import cn.itweet.modules.admin.article.repository.ArticleCategoriesRepository;
import cn.itweet.modules.admin.article.repository.ArticleRepository;
import cn.itweet.modules.admin.article.repository.ArticleTagRepository;
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
    public List<Article> findByTitle(String string) {
        return articleRepository.findByTitle(string);
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
    public void update(Article article,List<Integer> tagIds,Integer categoriesId) throws SystemException {
        Article oldArt = checkArticleInfo(article, "更新失败，要更新的文章名称不能为空！", "更新失败，要更新的文章名称已经存在！", "更新失败，要更新的文章作者不能为空！", "更新失败，要更新的文章内容不能为空！");
        updateArticle(article, oldArt);
        updateArticleTagInfo(tagIds, oldArt);
        updateCategoriesInfo(categoriesId, oldArt);
    }

    private void updateCategoriesInfo(Integer categoriesId, Article oldArt) {
        if (categoriesId != null)
            articleCategoriesRepository.delete(categoriesId);
        addArticleCategories(categoriesId, oldArt.getId());
    }

    private void updateArticleTagInfo(List<Integer> tagIds, Article oldArt) {
        List<Integer> delTags = CommonUtils.getDeleteElements(tagIds,articleTagRepository.getTagIdsByArticleId(oldArt.getId()));
        List<Integer> aggTags = CommonUtils.getAggrandizeElements(tagIds,articleTagRepository.getTagIdsByArticleId(oldArt.getId()));
        if (delTags.size() > 0)
            for (Integer tagId : delTags) {
                articleTagRepository.deleteByArticleIdAndTagId(oldArt.getId(),tagId);
            }
        if (aggTags.size() > 0)
            addArticleTag(tagIds, oldArt.getId());
    }

    private void updateArticle(Article article, Article oldArt) {
        oldArt.setAuthor(article.getAuthor());
        oldArt.setContent(article.getContent());
        oldArt.setCreateDate(oldArt.getCreateDate());
        oldArt.setTitle(article.getTitle());
        oldArt.setUpdateDate(new Date());
        articleRepository.save(oldArt);
    }

    @Override
    public Article addArticle(Article article,List<Integer> tagIds,Integer categoriesId) throws SystemException {
        Article art = checkArticleInfo(article, "添加失败，要添加的文章名称不能为空！", "添加失败，要添加的文章名称已经存在，不可重复添加！", "添加失败，要添加的文章作者不能为空！", "添加失败，要添加的文章内容不能为空！");
        Article a = articleRepository.save(art);
        addArticleCategories(categoriesId, a.getId());
        addArticleTag(tagIds, a.getId());
        return a;
    }

    private Article checkArticleInfo(Article article, String message, String message2, String message3, String message4) throws SystemException {
        Article art = articleRepository.getArticleByTitle(article.getTitle());
        if ("" == article.getTitle() || article.getTitle() == null)
            throw new SystemException(message);
        if (art != null)
            throw new SystemException(message2);
        if ("" == article.getAuthor() || article.getAuthor() == null)
            throw new SystemException(message3);
        if ("" == article.getContent() || article.getContent() == null)
            throw new SystemException(message4);
        return art;
    }

    private void addArticleCategories(Integer categoriesId, Integer articleId) {
        if (categoriesId == null) {
            articleCategoriesRepository.save(new ArticleCategories(-1, articleId)); //默认分类 -1
        } else {
            articleCategoriesRepository.save(new ArticleCategories(categoriesId, articleId));
        }
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
