package cn.itweet.modules.front.theme.effe;

import cn.itweet.common.config.ItweetProperties;
import cn.itweet.common.utils.PageUtils;
import cn.itweet.modules.admin.article.entity.Article;
import cn.itweet.modules.admin.article.service.article.ArticleService;
import cn.itweet.modules.admin.article.utils.ArticleDto;
import cn.itweet.modules.admin.article.utils.ArticleUtils;
import cn.itweet.modules.admin.course.entity.Course;
import cn.itweet.modules.admin.course.service.CourseService;
import cn.itweet.modules.admin.document.entiry.Document;
import cn.itweet.modules.admin.document.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    private CourseService courseService;

    @Autowired
    private ItweetProperties itweetProperties;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("home","selected");

        Page<ArticleDto> listArticle = articleService.list(0, ArticleUtils.getIsPublished(),ArticleUtils.getIsTweet());
        model.addAttribute("articleFirst",listArticle.getContent().get(0));
        model.addAttribute("articleLast",listArticle.getContent().get(1));

        model.addAttribute("listArticle",listArticle);

        List<Course> courseList = courseService.getCourseTopN(2);
        model.addAttribute("courseList",courseList);

        List<Document> documentList = storageService.getNewDocumentTopN("index",4);
        model.addAttribute("documentList",documentList);

        return "front/theme/effe/home";
    }

    @GetMapping(value = "/about")
    public String about(Model model) {
        model.addAttribute("about","selected");
        return "front/theme/effe/about";
    }

    @GetMapping(value = "/tweet")
    public String tweet(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        if(page != 0) page = page -1;

        model.addAttribute("tweet","selected");
        Page<ArticleDto> listArticle = articleService.list(page, ArticleUtils.getIsPublished(),ArticleUtils.getIsTweet());
        model.addAttribute("listArticle",listArticle);

        PageUtils pageUtils = new PageUtils("/tweet",page,listArticle.getTotalPages(),listArticle.getTotalElements(),itweetProperties.getPagSize());
        model.addAttribute("pb",pageUtils);

        return "front/theme/effe/tweet";
    }

    @GetMapping(value = "/tweet/{year}/{month}/{day}/{title}")
    public String tweetSingle(@PathVariable("year") Integer year,@PathVariable("month") Integer month,@PathVariable("day") Integer day,@PathVariable("title") String title, Model model) {
        model.addAttribute("tweet","selected");

        Article article = articleService.getArticleByTitle(title);
        model.addAttribute("article",article);

        List<String> tagsList = articleService.getArticleTagsByArticleId(article.getId());
        model.addAttribute("tagsList",tagsList.toString());

        return "front/theme/effe/tweetSingle";
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
        List<Course> courseList = courseService.list();
        model.addAttribute("courseList",courseList);
        return "front/theme/effe/portfolio";
    }

    @GetMapping(value = "/portfolio/projectSample/{id}")
    public String ProjectSample(@PathVariable Integer id, Model model) {
        Course course = courseService.findById(id);
        model.addAttribute("course",course);

        List<Course> courseList = courseService.getCourseTopN(3);
        model.addAttribute("courseList",courseList);

        return "front/theme/effe/projectSample";
    }

    @GetMapping(value = "/projectSample")
    public String projectSample(Model model) {
        model.addAttribute("projectSample","selected");
        return "front/theme/effe/projectSample";
    }

}
