package cn.itweet.modules.admin.article.web;

import cn.itweet.modules.admin.user.entity.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by whoami on 17/04/2017.
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleController {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model) {
        return "admin/article/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model) {
        return "admin/article/add";
    }
}
