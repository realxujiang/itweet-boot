package cn.itweet.modules.admin.user.web;

import cn.itweet.common.utils.LeftMenu;
import cn.itweet.common.utils.PageUtils;
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
 * 说明：资源管理Controller
 * 包名：cn.itweet.modules.admin.permission.web
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/13.
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
    public String list(@RequestParam(value = "page", defaultValue = "0") Integer page,@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {

        if(page !=0)page = page -1;

        Page<SysPermission> permissionList = permissionService.list(new PageRequest(page, pageSize));
        model.addAttribute("permissionList",permissionList);

        PageUtils pageUtils = new PageUtils(page,permissionList.getTotalPages(),permissionList.getTotalElements(),pageSize);
        model.addAttribute("pb",pageUtils);

        return "admin/user/p_list";
    }







}
