package cn.itweet.modules.admin.user.web;

import cn.itweet.common.exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 说明：
 * 包名：cn.itweet.modules.admin.user.web
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/13.
 */
@Controller
public class UserController {

    /**
     * 后台Main
     * @param model
     * @return
     */
    @GetMapping(value = "/admin/user/list")
    public String main(Map<String, Object> model) {
        System.out.println("--------------用户List----------");
        return "admin/user/list";
    }

    @RequestMapping("/json")
    public String json() throws SystemException {
        throw new SystemException("发生全局异常测试");
    }

}
