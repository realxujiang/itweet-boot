package cn.itweet.modules.admin.licence.web;

import cn.itweet.common.exception.ValidateException;
import cn.itweet.modules.admin.licence.entity.Licence;
import cn.itweet.modules.admin.licence.service.LicenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Autowired
    private LicenceService licenceService;

    /**
     * Licence授权列表
     * @return
     */
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String list(HttpServletRequest request){
        List<Licence> list = licenceService.list();
        request.setAttribute("list",list);
        return "admin/licence/list";
    }

    /**
     * Licence授权页面
     * @return
     */
    @RequestMapping(value="/add", method= RequestMethod.GET)
    public String add(){
        return "admin/licence/add";
    }

    /**
     * 添加Licence授权记录
     * @param licence
     * @param request
     * @return
     */
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(Licence licence, HttpServletRequest request){

        try{
            licenceService.add(licence);
        }catch (ValidateException v){
            request.setAttribute("errorMessage",v.getMessage());
            request.setAttribute("form",licence);
            return "admin/licence/add";
        }
        return "redirect:/admin/licence/list";
    }
}
