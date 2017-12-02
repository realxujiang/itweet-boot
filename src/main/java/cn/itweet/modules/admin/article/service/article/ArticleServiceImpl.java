package cn.itweet.modules.admin.article.service.article;

import cn.itweet.common.config.ItweetProperties;
import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.CommonUtils;
import cn.itweet.common.utils.SimplePageBuilder;
import cn.itweet.common.utils.SimpleSortBuilder;
import cn.itweet.modules.admin.article.entity.*;
import cn.itweet.modules.admin.article.repository.ArticleCategoriesRepository;
import cn.itweet.modules.admin.article.repository.ArticleRepository;
import cn.itweet.modules.admin.article.repository.ArticleTagRepository;
import cn.itweet.modules.admin.article.repository.TagRepository;
import cn.itweet.modules.admin.article.utils.ArticleDto;
import cn.itweet.modules.admin.article.utils.ArticleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    private ItweetProperties itweetProperties;

    @Override
    public Page<ArticleDto> list(Integer page) {
        return articleRepository.list(SimplePageBuilder.generate(page,itweetProperties.getPagSize(), SimpleSortBuilder.generateSort("createDate_d")));
    }

    @Override
    public Page<ArticleDto> list(Integer page,Integer state) {
        return articleRepository.list(SimplePageBuilder.generate(page,itweetProperties.getPagSize(), SimpleSortBuilder.generateSort("createDate_d")),state);
    }

    @Override
    public Page<ArticleDto> list(Integer page, Integer state, Integer articleType) {
        return articleRepository.list(SimplePageBuilder.generate(page, itweetProperties.getPagSize(),SimpleSortBuilder.generateSort("createDate_d")),state,articleType);
    }

    @Override
    public Map<String, List<ArticleDto>> archive() {
        String sql = "select * from (select distinct DATE_FORMAT(a.create_date,'%Y') as create_date,\"test\" from article a where a.state=1) b order by b.create_date desc";
        List<Object[]> list = articleRepository.listBySQL(sql);
        Map<String, List<ArticleDto>> listMap = new LinkedHashMap<>();
        for (int i=0; i<list.size(); i++) {
            Object[] obj = list.get(i);
            String year = obj[0].toString();
            List<Object[]> articleList = articleRepository.listBySQL("select a.create_date,a.title from article a where a.state=1 and DATE_FORMAT(a.create_date,'%Y')="+year+" order by a.create_date desc");
            List<ArticleDto> articleDtoList = new ArrayList<>();
            for (int j=0; j< articleList.size(); j++) {
                Object[] article = articleList.get(j);
                ArticleDto articleDto = new ArticleDto();
                articleDto.setCreateDate((Date) article[0]);
                articleDto.setTitle((String) article[1]);
                articleDtoList.add(articleDto);
            }
            listMap.put(year,articleDtoList);
        }
        return listMap;
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
            return new ArrayList<>();

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

        //articleCategoriesRepository.deleteByCategoriesId(oldCategoriesId);
        System.out.println("====>"+oldCategoriesId);
        System.out.println("====>"+oldArt.getId());
        ArticleCategories articleCategories = articleCategoriesRepository.findByCategoriesIdAndArticleId(oldCategoriesId,oldArt.getId());
        articleCategories.setCategoriesId(categoriesId);

        articleCategoriesRepository.save(articleCategories);
    }

    private void updateArticleTagInfo(List<Integer> tagIds, Article oldArt){
        List<Integer> tagIdsDB =articleTagRepository.getTagIdsByArticleId(oldArt.getId());

        if (tagIds.isEmpty() && tagIdsDB.isEmpty()) {
            return;
        }

        if (tagIds.isEmpty() && tagIdsDB.size() > 0) {
            for (Integer tagId : tagIdsDB) {
                articleTagRepository.deleteByArticleIdAndTagId(oldArt.getId(),tagId);
            }
        } else if (tagIdsDB.isEmpty() && tagIds != null) {
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
        oldArt.setTypeArticle(article.getTypeArticle());
        oldArt.setCoverPicture(article.getCoverPicture());
        articleRepository.save(oldArt);
    }

    @Override
    public Page<ArticleDto> searchByTitle(Integer page, String title) {
        return articleRepository.searchByTitle(SimplePageBuilder.generate(page,itweetProperties.getPagSize(),SimpleSortBuilder.generateSort("createDate_d")),title);
    }

    @Override
    public List<String> getArticleTagsByArticleId(Integer articleId) {
        return articleRepository.getArticleTagsByArticleId(articleId);
    }

    @Override
    public List<ArticleDto> getArticleRecentPostsTopN(Integer topNum) {
        String sql = "select cover_picture,title,SUBSTRING(description,1,20),create_date from article where state=1 order by create_date desc limit "+topNum;
        List<Object[]> list = articleRepository.listBySQL(sql);
        List<ArticleDto> articleDtoList = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            Object[] obj = list.get(i);
            ArticleDto articleDto = new ArticleDto();
            articleDto.setCoverPicture((String) obj[0]);
            articleDto.setTitle((String) obj[1]);
            articleDto.setDescription((String) obj[2]);
            articleDto.setCreateDate((Date) obj[3]);
            articleDtoList.add(articleDto);
        }
        return articleDtoList;
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
        if (article.getCoverPicture() == null || "".equals(article.getCoverPicture())) {
            article.setCoverPicture("no-images.png");
        }
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
    public List<Article> listByCategoriesIdAndStatePage(Integer state, Integer categoriesId,Integer page,Integer pageSize) {
        Integer pageOffset = page*pageSize;
        return articleRepository.listByCategoriesIdAndStatePage(state,categoriesId,pageOffset,pageSize);
    }

    @Override
    public Integer listByCategoriesIdAndStateCount(Integer state, Integer categoriesId) {
        return articleRepository.listByCategoriesIdAndStateCount(state,categoriesId);
    }
}
