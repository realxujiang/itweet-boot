package cn.itweet.modules.admin.article.web;

import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.PageUtils;
import cn.itweet.modules.admin.article.entity.Categories;
import cn.itweet.modules.admin.article.service.categories.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 说明：文章类别Controller
 * 包名：cn.itweet.modules.admin.article.web
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/4/20.
 */
@Controller
@RequestMapping("/admin/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    /**
     * 文章类别列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model) {

        List<Categories> categoriesList =  categoriesService.list();
        model.addAttribute("categoriesList",categoriesList);
        return "admin/article/c_list";
    }

    /**
     * 文章类别按Name查询
     * @param model
     * @return
     */
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String select(@RequestParam(value = "name") String name,Model model) {
        List<Categories> categoriesList = categoriesService.selectByName(name);
        model.addAttribute("categoriesList",categoriesList);
        model.addAttribute("name",name);
        return "admin/article/c_list";
    }

    /**
     * 文章类别添加页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model) {
        return "admin/article/c_add";
    }

    /**
     * 文章类别添加
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Model model,HttpServletRequest request,Categories categories) {

        try {
            categories.setDate(new Date());
            categoriesService.addCategories(categories);
        } catch (SystemException e) {
            model.addAttribute("form",categories);
            model.addAttribute("message","<script>toastr.error(\"" + e.getMessage() + "\")</script>");
            return "admin/article/c_add";
        }
        return "redirect:/admin/categories/list";
    }

    /**
     * 文章类别修改页面
     * @param model
     * @param name
     * @return
     */
    @RequestMapping(value = "/edit/{name}",method = RequestMethod.GET)
    public String edit(Model model,@PathVariable String name) {
        Categories categories = categoriesService.getCategoriesByName(name);
        model.addAttribute("form",categories);
        return "admin/article/c_edit";
    }

    /**
     * 文章类别修改
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(Model model,HttpServletRequest request,Categories categories) {
        try {
            categories.setDate(new Date());
            categoriesService.update(categories);
        } catch (SystemException e) {
            model.addAttribute("form",categories);
            model.addAttribute("message","<script>toastr.error(\"" + e.getMessage() + "\")</script>");
            return "admin/article/c_edit";
        }
        return "redirect:/admin/categories/list";
    }

    /**
     * 文章类别按ID删除
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(Model model,@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        try {
            categoriesService.deleteById(id);
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message","<script>toastr.error(\"" + e.getMessage() + "\")</script>");
            e.printStackTrace();
            return "redirect:/admin/categories/list";
        }
        return "redirect:/admin/categories/list";
    }
}
