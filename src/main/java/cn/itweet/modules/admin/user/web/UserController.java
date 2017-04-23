package cn.itweet.modules.admin.user.web;

import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.LeftMenu;
import cn.itweet.modules.admin.user.entity.SysRole;
import cn.itweet.modules.admin.user.entity.SysUser;
import cn.itweet.modules.admin.user.service.role.RoleService;
import cn.itweet.modules.admin.user.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 说明：用户管理Controller
 * 包名：cn.itweet.modules.admin.user.web
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/13.
 */
@Controller
@RequestMapping(value = "/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 用户列表
     * @param model
     * @return
     */
    @LeftMenu(name = "用户列表",descritpion = "admin_user_list",pname = "用户管理",url = "/admin/user/list",operation = "list")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model) {
        List<SysUser> userList = userService.list();
        model.addAttribute("userList",userList);
        return "admin/user/u_list";
    }

    /**
     * 添加用户页面
     * @return
     */
    @LeftMenu(name = "用户添加",descritpion = "admin_user_add",pname = "用户管理",url = "/admin/user/add",operation = "add")
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        List<SysRole> roleList = roleService.list();
        model.addAttribute("roleList",roleList);
        return "admin/user/u_add";
    }

    /**
     * 添加用户
     * @param sysUser
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam List<Integer> rIds, SysUser sysUser, HttpServletRequest request){
        try {
            sysUser.setPassword("123456");
            userService.add(sysUser,rIds);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/user/list";
    }

    /**
     * 修改用户页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    @LeftMenu(name = "用户修改",descritpion = "admin_user_edit",pname = "用户管理",url = "/admin/user/edit/*",operation = "update")
    public String edit(@PathVariable Integer id,Model model,HttpServletRequest request){
        SysUser su = userService.findById(id);
        model.addAttribute("form",su);

        List<SysRole> roleList = roleService.list();
        model.addAttribute("roleList",roleList);

        System.out.println("取出所有RoleIDS：" + roleList.toString());
        List<Integer> roleIds = roleService.getRoleIdsByUid(id);
        model.addAttribute("rids",roleIds);

        System.out.println("取出roleIds:" + roleIds.toString());

        return "/admin/user/u_edit";
    }

    /**
     * 修改用户
     * @param sysUser
     * @param request
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(@RequestParam List<Integer> rIds,SysUser sysUser,HttpServletRequest request){
        try {
            System.out.println("RoleIds:"+rIds.toString());
            System.out.println("UserId:"+sysUser.getId());
            System.out.println(sysUser.getPassword());
            userService.update(sysUser,rIds);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/user/list";
    }

    /**
     * 删除用户
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @LeftMenu(name = "用户删除",descritpion = "admin_user_delete",pname = "用户管理",url = "/admin/user/delete",operation = "delete")
    public String delete(@PathVariable Integer id, HttpServletRequest request){
        try {
            userService.deleteById(id);
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return "redirect:/admin/user/list";
    }

    /**
     * 重置用户密码
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/resetPassword/{id}",method = RequestMethod.GET)
    @LeftMenu(name = "重置密码",descritpion = "admin_user_delete",pname = "用户管理",url = "/admin/user/delete",operation = "delete")
    public String ResetPassword(@PathVariable Integer id, HttpServletRequest request){
        SysUser su = userService.findById(id);
        su.setPassword("123456");
        try {
            userService.update(su);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/user/list";
    }

}
