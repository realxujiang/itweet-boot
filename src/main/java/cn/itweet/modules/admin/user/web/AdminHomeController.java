package cn.itweet.modules.admin.user.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by whoami on 10/02/2017.
 */
@Controller
public class AdminHomeController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping(value = "/admin/home")
    public String welcome(Map<String, Object> model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("====welcom username====="+auth.getName());
        model.put("time", new Date());
        model.put("message", this.message);
        return "admin/home";
    }
}
