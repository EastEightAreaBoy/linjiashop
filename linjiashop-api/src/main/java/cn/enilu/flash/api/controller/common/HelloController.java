package cn.enilu.flash.api.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wzj
 * 2020-03-03
 **/
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String validate() {
        return "ok";
    }

}
