package cn.itweet.modules.front.theme.effe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by whoami on 22/04/2017.
 */
@Controller
public class EffeController {

    @GetMapping(value = "/")
    public String home() {
        return "front/home";
    }

}
