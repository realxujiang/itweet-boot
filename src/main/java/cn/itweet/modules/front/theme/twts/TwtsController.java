package cn.itweet.modules.front.theme.twts;

import cn.itweet.common.config.ItweetProperties;
import cn.itweet.common.utils.PageUtils;
import cn.itweet.modules.admin.article.entity.Article;
import cn.itweet.modules.admin.article.service.article.ArticleService;
import cn.itweet.modules.admin.article.service.categories.CategoriesService;
import cn.itweet.modules.admin.article.utils.ArticleDto;
import cn.itweet.modules.admin.article.utils.ArticleUtils;
import cn.itweet.modules.admin.article.utils.CategoriesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by whoami on 27/04/2017.
 */
@Controller
public class TwtsController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private ItweetProperties itweetProperties;

    @GetMapping(value = "/blog")
    public String index(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        if(page != 0) page = page -1;

        List<ArticleDto> topArticle = articleService.getArticleRecentPostsTopN(5);
        model.addAttribute("topArticle",topArticle);

        Page<ArticleDto> listArticle = articleService.list(page, ArticleUtils.getIsPublished());
        model.addAttribute("listArticle",listArticle.getContent());

        List<CategoriesDto> categoriesList = categoriesService.getCategoriesArticleCount();
        model.addAttribute("categoriesList",categoriesList);

        PageUtils pageUtils = new PageUtils("/blog?",page,listArticle.getTotalPages(),listArticle.getTotalElements(),itweetProperties.getPagSize());
        model.addAttribute("pb",pageUtils);

        return "front/theme/twts/index";
    }

    @GetMapping(value = "/blog/select")
    public String select(@RequestParam(value = "title") String title,@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        if(page != 0) { page = page-1; }

        List<ArticleDto> topArticle = articleService.getArticleRecentPostsTopN(5);
        model.addAttribute("topArticle",topArticle);

        Page<ArticleDto> listArticle = articleService.searchByTitle(page,title);
        model.addAttribute("listArticle",listArticle.getContent());

        List<CategoriesDto> categoriesList = categoriesService.getCategoriesArticleCount();
        model.addAttribute("categoriesList",categoriesList);

        PageUtils pageUtils = new PageUtils("/blog/select?title="+title+"&",page,listArticle.getTotalPages(),listArticle.getTotalElements(),itweetProperties.getPagSize());
        model.addAttribute("pb",pageUtils);

        return "front/theme/twts/index";
    }

    @RequestMapping(value = "/blog/about",method = RequestMethod.GET)
    public String about(Model model) {
        return "front/theme/twts/about";
    }

    @RequestMapping(value = "/blog/archive",method = RequestMethod.GET)
    public String archive(Model model) {

        Map<String, List<ArticleDto>> mapArticle = articleService.archive();
        model.addAttribute("mapArticle",mapArticle);

        return "front/theme/twts/full-width";
    }

    @RequestMapping(value = "/blog/{year}/{month}/{day}/{title}",method = RequestMethod.GET)
    public String single(@PathVariable("year") Integer year,@PathVariable("month") Integer month,@PathVariable("day") Integer day,@PathVariable("title") String title, Model model) {
        //String content= URLDecoder.decode(title,"UTF-8");

        Article article = articleService.getArticleByTitle(title);
        model.addAttribute("article",article);

        List<String> tagsList = articleService.getArticleTagsByArticleId(article.getId());
        model.addAttribute("tagsList",tagsList.toString());

        List<ArticleDto> topArticle = articleService.getArticleRecentPostsTopN(5);
        model.addAttribute("topArticle",topArticle);

        List<CategoriesDto> categoriesList = categoriesService.getCategoriesArticleCount();
        model.addAttribute("categoriesList",categoriesList);

        return "front/theme/twts/single";
    }

    @RequestMapping(value = "/blog/contact",method = RequestMethod.GET)
    public String contact(Model model) {
        return "front/theme/twts/contact";
    }

    @RequestMapping(value = "/blog/history",method = RequestMethod.GET)
    public String history(Model model) {
        return "front/theme/twts/history";
    }

    @RequestMapping(value = "/blog/categories/{id}",method = RequestMethod.GET)
    public String listByCategoriesId(@PathVariable("id") Integer id,@RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {

        if(page != 0) { page = page-1; }

        List<ArticleDto> topArticle = articleService.getArticleRecentPostsTopN(5);
        model.addAttribute("topArticle",topArticle);

        Integer totalCounts = articleService.listByCategoriesIdAndStateCount(ArticleUtils.getIsPublished(),id);

        Integer pageSize = itweetProperties.getPagSize();

        Integer getTotalPages = (int)Math.ceil(totalCounts/pageSize);

        List<Article> listArticle = articleService.listByCategoriesIdAndStatePage(ArticleUtils.getIsPublished(),id,page,pageSize);
        model.addAttribute("listArticle",listArticle);

        List<CategoriesDto> categoriesList = categoriesService.getCategoriesArticleCount();
        model.addAttribute("categoriesList",categoriesList);

        PageUtils pageUtils = new PageUtils("/blog/categories/"+id+"?",page,getTotalPages,listArticle.size(),pageSize);
        model.addAttribute("pb",pageUtils);

        return "front/theme/twts/list";
    }

}
