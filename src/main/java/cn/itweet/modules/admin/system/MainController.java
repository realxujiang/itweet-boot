package cn.itweet.modules.admin.system;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

/**
 * 说明：
 * 包名：cn.itweet.modules.admin.system
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/13.
 */
@Controller
public class MainController {

    /**
     * 后台Main
     * @param model
     * @return
     */
    @GetMapping(value = "/admin/system/main")
    public String main(Map<String, Object> model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("----------->"+username+"<-----------");
        return "admin/system/main";
    }

    /**
     * 后台Body
     * @param model
     * @return
     */
    @GetMapping(value = "/admin/system/body")
    public String body(Map<String, Object> model) {
        System.out.println("--------------后台Body----------");
        return "admin/system/body";
    }

}
