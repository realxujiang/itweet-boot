package cn.itweet.modules.admin.system;

import cn.itweet.common.utils.RootMenu;
import org.springframework.stereotype.Controller;

/**
 * Created by whoami on 18/04/2017.
 */
@Controller
public class RootController {

    @RootMenu(pid = "0",name = "用户管理",operation = "manager",pname = "root",descritpion = "user_manager",url = "/admin/user")
    public String userManager() {
        return "UserManager";
    }


    @RootMenu(pid = "0",name = "角色管理",operation = "manager",pname = "root",descritpion = "role_manager",url = "/admin/role")
    public String roleManager() {
        return "roleManager";
    }

    @RootMenu(pid = "0",name = "资源管理",operation = "manager",pname = "root",descritpion = "permission_manager",url = "/admin/permission")
    public String permissionManager() {
        return "permissionManager";
    }

    @RootMenu(pid = "0",name = "文章管理",operation = "manager",pname = "root",descritpion = "article_manager",url = "/admin/article")
    public String articleManager() {
        return "articleManager";
    }
}
