package cn.itweet.modules.front.theme.effe;

import cn.itweet.common.config.ItweetProperties;
import cn.itweet.common.utils.PageUtils;
import cn.itweet.modules.admin.article.entity.Article;
import cn.itweet.modules.admin.article.service.article.ArticleService;
import cn.itweet.modules.admin.article.utils.ArticleDto;
import cn.itweet.modules.admin.article.utils.State;
import cn.itweet.modules.admin.document.entiry.Document;
import cn.itweet.modules.admin.document.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by whoami on 22/04/2017.
 */
@Controller
public class EffeController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private ItweetProperties itweetProperties;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("home","selected");

        List<ArticleDto> listArticle = articleService.getArticleRecentPostsTopN(2);
        model.addAttribute("articleFirst",listArticle.get(0));
        model.addAttribute("articleLast",listArticle.get(1));

        List<Document> documentList = storageService.getNewDocumentTopN("index",4);
        model.addAttribute("documentList",documentList);

        return "front/theme/effe/home";
    }

    @GetMapping(value = "/about")
    public String about(Model model) {
        model.addAttribute("about","selected");
        return "front/theme/effe/about";
    }

    @GetMapping(value = "/blog")
    public String blog(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        if(page != 0) page = page -1;

        model.addAttribute("blog","selected");
        Page<ArticleDto> listArticle = articleService.list(page, State.getIsPublished());
        model.addAttribute("listArticle",listArticle);

        PageUtils pageUtils = new PageUtils("/bolg?",page,listArticle.getTotalPages(),listArticle.getTotalElements(),itweetProperties.getPagSize());
        model.addAttribute("pb",pageUtils);

        return "front/theme/effe/blog";
    }

    @GetMapping(value = "/blog/{year}/{month}/{day}/{title}")
    public String blogSingle(@PathVariable("year") Integer year,@PathVariable("month") Integer month,@PathVariable("day") Integer day,@PathVariable("title") String title, Model model) {
        model.addAttribute("blog","selected");
        Article article = articleService.getArticleByTitle(title);
        List<String> tagsList = articleService.getArticleTagsByArticleId(article.getId());
        model.addAttribute("article",article);
        model.addAttribute("tagsList",tagsList.toString());
        return "front/theme/effe/si";
    }

    @GetMapping(value = "/contact")
    public String contact(Model model) {
        model.addAttribute("contact","selected");
        return "front/theme/effe/contact";
    }

    @GetMapping(value = "/features")
    public String features(Model model) {
        model.addAttribute("features","selected");
        return "front/theme/effe/features";
    }

    @GetMapping(value = "/portfolio")
    public String portfolio(Model model) {
        model.addAttribute("portfolio","selected");
        return "front/theme/effe/portfolio";
    }

    @GetMapping(value = "/projectSample")
    public String projectSample(Model model) {
        model.addAttribute("projectSample","selected");
        return "front/theme/effe/projectSample";
    }

}
