package cn.itweet.modules.admin.article.web;

import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.PageUtils;
import cn.itweet.modules.admin.article.entity.Tag;
import cn.itweet.modules.admin.article.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 说明：文章标签Controller
 * 包名：cn.itweet.modules.admin.article.web
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/4/20.
 */
@Controller
@RequestMapping("/admin/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     *文章标签列表
     * @param page
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {

        if(page !=0)page = page -1;

        Page<Tag> tagList = tagService.list(new PageRequest(page, pageSize));
        model.addAttribute("tagList",tagList);

        PageUtils pageUtils = new PageUtils("/admin/tag/list?",page,tagList.getTotalPages(),tagList.getTotalElements(),pageSize);
        model.addAttribute("pb",pageUtils);

        return "admin/article/t_list";
    }

    /**
     * 文章标签按Name查询
     * @param page
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String select(@RequestParam(value = "name") String name, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
        if(page !=0)page = page -1;
        Page<Tag> tagList = tagService.selectByName(new PageRequest(page, pageSize),name);
        model.addAttribute("tagList",tagList);

        PageUtils pageUtils = new PageUtils("/admin/tag/select?name="+ name+"&",page,tagList.getTotalPages(),tagList.getTotalElements(),pageSize);
        model.addAttribute("pb",pageUtils);

        model.addAttribute("name",name);
        return "admin/article/t_list";
    }

    /**
     * 文章标签添加页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model) {
        return "admin/article/t_add";
    }

    /**
     * 文章标签添加
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Model model,HttpServletRequest request,Tag tag) {
        try {
            tag.setDate(new Date());
            tagService.addTag(tag);
        } catch (SystemException e) {
            model.addAttribute("form",tag);
            model.addAttribute("message","<script>toastr.error(\"" + e.getMessage() + "\")</script>");
            return "admin/article/t_add";
        }
        return "redirect:/admin/tag/list";
    }

    /**
     * 文章标签修改页面
     * @param model
     * @param name
     * @return
     */
    @RequestMapping(value = "/edit/{name}",method = RequestMethod.GET)
    public String edit(Model model,@PathVariable String name) {
        Tag tag = tagService.getTagByName(name);
        model.addAttribute("form",tag);
        return "admin/article/t_edit";
    }

    /**
     * 文章标签修改
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(Model model,HttpServletRequest request,Tag tag) {
        try {
            tag.setDate(new Date());
            tagService.update(tag);
        } catch (SystemException e) {
            model.addAttribute("form",tag);
            model.addAttribute("message","<script>toastr.error(\"" + e.getMessage() + "\")</script>");
            return "admin/article/t_edit";
        }
        return "redirect:/admin/tag/list";
    }

    /**
     * 文章标签按ID删除
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(Model model,@PathVariable Integer id) {
        tagService.deleteById(id);
        return "redirect:/admin/tag/list";
    }

}
