package cn.itweet.modules.admin.licence.web;

import cn.itweet.common.exception.ValidateException;
import cn.itweet.modules.admin.licence.entity.Licence;
import cn.itweet.modules.admin.licence.service.LicenceService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     * Licence授权记录列表
     * @return
     */
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String list(HttpServletRequest request){
        List<Licence> list = licenceService.list();
        request.setAttribute("licenceNumber",list.size());
        request.setAttribute("list",list);
        return "admin/licence/list";
    }

    /**
     * Licence授权记录添加页面
     * @return
     */
    @RequestMapping(value="/add", method= RequestMethod.GET)
    public String add(){
        return "admin/licence/add";
    }

    /**
     * Licence授权记录添加
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


    /**
     * Licence授权记录删除
     * @param request
     * @return
     */
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id, HttpServletRequest request){
        licenceService.delete(id);
        return "redirect:/admin/licence/list";
    }

    /**
     * Licence授权记录修改页面
     * @param request
     * @return
     */
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, HttpServletRequest request){
        Licence licence = licenceService.get(id);
        request.setAttribute("form",licence);
        return "admin/licence/edit";
    }

    /**
     * Licence授权记录修改
     * @param request
     * @return
     */
    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String edit(Licence licence, HttpServletRequest request){
        try {
            licenceService.edit(licence);
        } catch (ValidateException v) {
            request.setAttribute("errorMessage",v.getMessage());
            request.setAttribute("form",licence);
            return "admin/licence/edit";
        }
        return "redirect:/admin/licence/list";
    }

    /**
     * Licence授权码导出
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/export/{id}", method = RequestMethod.GET)
    public void export(@PathVariable Integer id, HttpServletRequest request,HttpServletResponse response){
        Licence licence = licenceService.get(id);
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=Redoop-CRH.rif");
        ServletOutputStream out;
        try {
            out = response.getOutputStream();
            out.write(licence.getCode().getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Licence授权记录按公司查询
     * @param request
     * @return
     */
    @RequestMapping(value="/select", method = RequestMethod.POST)
    public String select(HttpServletRequest request){
        String companyName = request.getParameter("companyName");
        System.out.println(companyName);
        List<Licence> list = licenceService.getByCompany(companyName);
        for(Licence licence:list){
            System.out.println(licence.toString());
        }
        request.setAttribute("licenceNumber",list.size());
        request.setAttribute("companyName",companyName);
        request.setAttribute("list",list);
        return "admin/licence/list";
    }

}
