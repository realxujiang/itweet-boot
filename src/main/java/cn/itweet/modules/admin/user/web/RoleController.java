package cn.itweet.modules.admin.user.web;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entity.SysRole;
import cn.itweet.modules.admin.user.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 说明：角色管理Controller
 * 包名：cn.itweet.modules.admin.user.web
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/29.
 */
@Controller
@RequestMapping(value = "/admin/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 角色列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String main(Model model) {
        List<SysRole> roleList = roleService.list();
        model.addAttribute("roleList",roleList);
        return "admin/user/r_list";
    }

    /**
     * 添加角色页面
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "admin/user/r_add";
    }

    /**
     * 添加角色
     * @param sysRole
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(SysRole sysRole, HttpServletRequest request){
        try {
            roleService.add(sysRole);
        } catch (SystemException e) {

            String temp = "toastr.error(\"角色添加失败\",\"管理员角色添加失败\")";

            request.setAttribute("message",temp);
            return "admin/user/r_add";
        }
        return "redirect:/admin/role/list";
    }

    /**
     * 修改角色页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model, HttpServletRequest request){
        SysRole sr = roleService.findById(id);
        model.addAttribute("form",sr);
        return "/admin/user/r_edit";
    }

    /**
     * 修改角色
     * @param sysRole
     * @param request
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(SysRole sysRole,HttpServletRequest request){
        try {
            roleService.update(sysRole);
        } catch (SystemException e) {
            request.setAttribute("message","");
            e.printStackTrace();
        }

        return "redirect:/admin/role/list";
    }

    /**
     * 删除角色
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable Integer id, HttpServletRequest request){
        try {
            roleService.deleteById(id);
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return "redirect:/admin/role/list";
    }

    /**
     * 角色授权
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/authorization/{id}",method = RequestMethod.GET)
    public String authorization(@PathVariable Integer id, HttpServletRequest request){
        return "/admin/user/r_edit";
    }

}
