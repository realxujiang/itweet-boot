package cn.itweet.modules.admin.user.web;

import cn.itweet.common.utils.LeftMenu;
import cn.itweet.modules.admin.user.entity.SysPermission;
import cn.itweet.modules.admin.user.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by whoami on 09/04/2017.
 */
@Controller
@RequestMapping(value = "/admin/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    /**
     * 资源列表
     * @param model
     * @return
     */
    @LeftMenu(name = "资源列表",descritpion = "admin_permission_list",pname = "资源管理",url = "/admin/permission/list",operation = "list")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", defaultValue = "0") Integer page,@RequestParam(value = "size", defaultValue = "10") Integer size,Model model) {
        System.out.println("Page:"+page);
        System.out.println("Size:"+size);
        Page<SysPermission> permissionList = permissionService.list(new PageRequest(page, size));
        model.addAttribute("permissionList",permissionList);
        return "admin/user/p_list";
    }







}
