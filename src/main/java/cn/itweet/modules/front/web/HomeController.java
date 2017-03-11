package cn.itweet.modules.front.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by whoami on 11/03/2017.
 */
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String home() {
        return "front/home";
    }

}
