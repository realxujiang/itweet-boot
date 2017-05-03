package cn.itweet.modules.front.theme.twts;

import cn.itweet.common.config.ItweetProperties;
import cn.itweet.common.utils.PageUtils;
import cn.itweet.modules.admin.article.entity.Article;
import cn.itweet.modules.admin.article.entity.Categories;
import cn.itweet.modules.admin.article.service.article.ArticleService;
import cn.itweet.modules.admin.article.service.categories.CategoriesService;
import cn.itweet.modules.admin.article.utils.ArticleDto;
import cn.itweet.modules.admin.article.utils.State;
import cn.itweet.modules.admin.document.entiry.Document;
import cn.itweet.modules.admin.document.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        Page<ArticleDto> listArticle = articleService.list(page, State.getIsPublished());
        model.addAttribute("listArticle",listArticle);

        List<Categories> categoriesList = categoriesService.list();
        model.addAttribute("categoriesList",categoriesList);

        PageUtils pageUtils = new PageUtils("/bolg?",page,listArticle.getTotalPages(),listArticle.getTotalElements(),itweetProperties.getPagSize());
        model.addAttribute("pb",pageUtils);

        return "front/theme/twts/index";
    }

    @RequestMapping(value = "/blog/about",method = RequestMethod.GET)
    public String about(Model model) {
        return "front/theme/twts/about";
    }

    @RequestMapping(value = "/blog/archive",method = RequestMethod.GET)
    public String archive(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        if(page != 0) page = page -1;

        Page<ArticleDto> listArticle = articleService.list(page, State.getIsPublished());
        model.addAttribute("listArticle",listArticle);

        return "front/theme/twts/full-width";
    }

    @RequestMapping(value = "/blog/{year}/{month}/{day}/{title}",method = RequestMethod.GET)
    public String single(@PathVariable("year") Integer year,@PathVariable("month") Integer month,@PathVariable("day") Integer day,@PathVariable("title") String title, Model model) {
        Article article = articleService.getArticleByTitle(title);
        List<String> tagsList = articleService.getArticleTagsByArticleId(article.getId());
        model.addAttribute("article",article);
        model.addAttribute("tagsList",tagsList.toString());
        return "front/theme/twts/single";
    }

    @GetMapping(value = "/blog/contact")
    public String contact(Model model) {
        return "front/theme/twts/contact";
    }

}
