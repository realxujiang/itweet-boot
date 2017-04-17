package cn.itweet.modules.admin.user.web;

import cn.itweet.common.utils.LeftMenu;
import cn.itweet.modules.admin.user.entity.SysPermission;
import cn.itweet.modules.admin.user.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by whoami on 09/04/2017.
 */
@Controller
@RequestMapping(value = "/admin/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    private int pageNum = 1;


    /**
     * 资源列表
     * @param model
     * @return
     */
    @LeftMenu(name = "资源列表",descritpion = "admin_permission_list",pname = "资源管理",url = "/admin/permission/list",operation = "list")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model) {
        //if(num !=null) pageNum = num;
        Page<SysPermission> permissionList = permissionService.list(pageNum);
        System.out.println("GGGGGGG:"+permissionList.toString());
        model.addAttribute("permissionList",permissionList);
        return "admin/user/p_list";
    }







}
