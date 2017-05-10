package cn.itweet.modules.admin.course.web;

import cn.itweet.common.config.ItweetProperties;
import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.PageUtils;
import cn.itweet.modules.admin.course.entity.Course;
import cn.itweet.modules.admin.course.service.CourseService;
import cn.itweet.modules.admin.document.entiry.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by whoami on 09/05/2017.
 */
@Controller
@RequestMapping("/admin/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ItweetProperties itweetProperties;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        if(page !=0) page = page -1;

        Page<Course> courseList = courseService.list(page);
        model.addAttribute("courseList",courseList);

        PageUtils pageUtils = new PageUtils("/admin/course/list?",page,courseList.getTotalPages(),courseList.getTotalElements(),itweetProperties.getPagSize());
        model.addAttribute("pb",pageUtils);

        return "admin/course/list";
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String searchByTitle(@RequestParam(value = "page", defaultValue = "0") Integer page,@RequestParam(value = "title") String title,Model model) {
        if(page !=0) page = page -1;

        Page<Course> courseList = courseService.searchByTitle(page,title);
        model.addAttribute("courseList",courseList);

        PageUtils pageUtils = new PageUtils("/admin/course/select?title="+ title+"&",page,courseList.getTotalPages(),courseList.getTotalElements(),itweetProperties.getPagSize());
        model.addAttribute("pb",pageUtils);

        model.addAttribute("title",title);

        return "admin/course/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model) {
        return "admin/course/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Course course,Model model) {
        try {
            courseService.add(course);
        } catch (SystemException e) {
            e.printStackTrace();
            model.addAttribute("message","<script>toastr.error(\"" + "add fail " + e.getMessage() + "!" + "\")</script>");
        }
        return "redirect:/admin/course/list";
    }


    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(Model model,@PathVariable Integer id) {
        courseService.deleteById(id);
        return "redirect:/admin/course/list";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(Model model,@PathVariable Integer id) {
        Course course = courseService.findById(id);
        model.addAttribute("form",course);
        return "admin/course/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(Model model, Course course) {
        courseService.update(course);
        return "redirect:/admin/course/list";
    }
}
