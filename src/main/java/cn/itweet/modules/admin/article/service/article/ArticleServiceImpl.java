package cn.itweet.modules.admin.article.service.article;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.article.entity.Article;
import cn.itweet.modules.admin.article.repository.ArticleCategoriesRepository;
import cn.itweet.modules.admin.article.repository.ArticleRepository;
import cn.itweet.modules.admin.article.repository.ArticleTagRepository;
import cn.itweet.modules.admin.article.utils.ArticleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void update(Article article) throws SystemException {
        Article art = articleRepository.getArticleByTitle(article.getTitle());
        if ("" == article.getTitle() || article.getTitle() == null)
            throw new SystemException("更新失败，要更新的文章名称不能为空！");
        if (art != null)
            throw new SystemException("更新失败，要更新的文章名称已经存在！");
        if ("" == article.getAuthor() || article.getAuthor() == null)
            throw new SystemException("更新失败，要更新的文章作者不能为空！");
        if ("" == article.getContent() || article.getContent() == null)
            throw new SystemException("更新失败，要更新的文章内容不能为空！");
        art.setAuthor(article.getAuthor());
        art.setContent(article.getContent());
        art.setCreateDate(art.getCreateDate());
        art.setTitle(art.getTitle());
        art.setUpdateDate(new Date());
        articleRepository.save(art);
    }

    @Override
    public Article addArticle(Article article) throws SystemException {
        Article art = articleRepository.getArticleByTitle(article.getTitle());
        if ("" == article.getTitle() || article.getTitle() == null)
            throw new SystemException("添加失败，要添加的文章名称不能为空！");
        if (art != null)
            throw new SystemException("添加失败，要添加的文章名称已经存在，不可重复添加！");
        if ("" == article.getAuthor() || article.getAuthor() == null)
            throw new SystemException("添加失败，要添加的文章作者不能为空！");
        if ("" == article.getContent() || article.getContent() == null)
            throw new SystemException("添加失败，要添加的文章内容不能为空！");
        return articleRepository.save(art);
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
