package cn.itweet.modules.admin.licence.web;

import cn.itweet.modules.admin.licence.entity.Licence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 说明：Licence Controller
 * 包名：cn.itweet.modules.admin.licence
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
@Controller
@RequestMapping(value = "/admin/licence")
public class LicenceController {


    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String list(){
        return "admin/licence/list";
    }

    @RequestMapping(value="/add", method= RequestMethod.GET)
    public String add(Model model, HttpServletRequest request){
        return "admin/licence/add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(Model model,Licence licence, HttpServletRequest request){
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSS");


        return "redirect:/admin/licence/list";
    }
}
