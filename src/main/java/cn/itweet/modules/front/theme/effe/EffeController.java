package cn.itweet.modules.front.theme.effe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by whoami on 22/04/2017.
 */
@Controller
public class EffeController {

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("home","selected");
        return "/front/theme/effe/home";
    }

    @GetMapping(value = "/about")
    public String about(Model model) {
        model.addAttribute("about","selected");
        return "/front/theme/effe/about";
    }

    @GetMapping(value = "/blogArticle")
    public String blog(Model model) {
        model.addAttribute("blog","selected");
        return "/front/theme/effe/blog";
    }

    @GetMapping(value = "/blogSingle")
    public String blogSingle(Model model) {
        model.addAttribute("blog","selected");
        return "/front/theme/effe/blogSingle";
    }

    @GetMapping(value = "/contact")
    public String contact(Model model) {
        model.addAttribute("contact","selected");
        return "/front/theme/effe/contact";
    }

    @GetMapping(value = "/features")
    public String features(Model model) {
        model.addAttribute("features","selected");
        return "/front/theme/effe/features";
    }

    @GetMapping(value = "/portfolio")
    public String portfolio(Model model) {
        model.addAttribute("portfolio","selected");
        return "/front/theme/effe/portfolio";
    }

    @GetMapping(value = "/projectSample")
    public String projectSample(Model model) {
        model.addAttribute("projectSample","selected");
        return "/front/theme/effe/projectSample";
    }

}
