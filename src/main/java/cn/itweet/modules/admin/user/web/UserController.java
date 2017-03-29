package cn.itweet.modules.admin.user.web;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.entity.SysUser;
import cn.itweet.modules.admin.user.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 说明：
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

    /**
     * 用户列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String main(Model model) {
        System.out.println("--------------用户List----------");
        List<SysUser> userList = userService.list();
        model.addAttribute("userList",userList);
        return "admin/user/list";
    }

    /**
     * 添加用户页面
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "admin/user/add";
    }

    /**
     * 添加用户
     * @param sysUser
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(SysUser sysUser,HttpServletRequest request){
        String[] strIds = request.getParameterValues("rIds");
        Integer[] temp = new Integer[strIds.length];
        for(int i=0; i<strIds.length; i++){
            temp[i] = Integer.parseInt(strIds[i]);
        }
        List<Integer> rIds = Arrays.asList(temp);

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
    public String edit(@PathVariable Integer id,HttpServletRequest request){

        return "/admin/user/edit";
    }

    /**
     * 修改用户
     * @param sysUser
     * @param request
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(SysUser sysUser,HttpServletRequest request){

        return "redirect:/admin/user/list";
    }

    /**
     * 删除用户
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable Integer id, HttpServletRequest request){

        return "redirect:/admin/user/list";
    }

    /**
     * 删除用户
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/resetPassword/{id}",method = RequestMethod.GET)
    public String ResetPassword(@PathVariable Integer id, HttpServletRequest request){

        return "redirect:/admin/user/list";
    }

}
