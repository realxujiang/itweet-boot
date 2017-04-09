package cn.itweet.modules.admin.user.web;

import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.LeftMenu;
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
    @LeftMenu(name = "角色列表",descritpion = "admin_role_list",pname = "角色管理",url = "/admin/role/list",operation = "list")
    public String list(Model model) {
        List<SysRole> roleList = roleService.list();
        model.addAttribute("roleList",roleList);
        return "admin/user/r_list";
    }

    /**
     * 添加角色页面
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @LeftMenu(name = "角色添加",descritpion = "admin_role_add",pname = "角色管理",url = "/admin/role/add",operation = "add")
    public String add(){
        return "admin/user/r_add";
    }

    /**
     * 添加角色
     * @param sysRole
     * @param model
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(SysRole sysRole, Model model){
        try {
            roleService.add(sysRole);
        } catch (SystemException e) {
            model.addAttribute("form",sysRole);
            model.addAttribute("message","<script>toastr.error(\"" + e.getMessage() + "\")</script>");
            return "admin/user/r_add";
        }
        return "redirect:/admin/role/list";
    }

    /**
     * 修改角色页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    @LeftMenu(name = "角色更新",descritpion = "admin_role_update",pname = "角色管理",url = "/admin/role/edit/*",operation = "update")
    public String edit(@PathVariable Integer id,Model model){
        SysRole sr = roleService.findById(id);
        model.addAttribute("form",sr);
        return "/admin/user/r_edit";
    }

    /**
     * 修改角色
     * @param sysRole
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(SysRole sysRole,Model model){
        try {
            roleService.update(sysRole);
        } catch (SystemException e) {
            model.addAttribute("form",sysRole);
            model.addAttribute("message","<script>toastr.error(\"" + e.getMessage() + "\")</script>");
            return "/admin/user/r_edit";
        }

        return "redirect:/admin/role/list";
    }

    /**
     * 删除角色
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @LeftMenu(name = "角色删除",descritpion = "admin_role_delete",pname = "角色管理",url = "/admin/role/delete/*",operation = "delete")
    public String delete(@PathVariable Integer id,Model model){
        try {
            roleService.deleteById(id);
        } catch (SystemException e) {
            model.addAttribute("message","<script>toastr.error(\"" + e.getMessage() + "\")</script>");
        }
        return "redirect:/admin/role/list";
    }

    /**
     * 角色授权页面
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/authorization/{id}",method = RequestMethod.GET)
    @LeftMenu(name = "角色授权",descritpion = "admin_role_authorization",pname = "角色管理",url = "/admin/role/authorization/*",operation = "update")
    public String authorization(@PathVariable Integer id, HttpServletRequest request){
        return "/admin/user/r_edit";
    }

}
