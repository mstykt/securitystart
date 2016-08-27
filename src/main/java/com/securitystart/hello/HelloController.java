package com.securitystart.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Hello Controller
 *
 * Created by mesut on 27.8.2016.
 */
@Controller
public class HelloController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String sayHi(Model model) {
        model.addAttribute("springParam", "Hello Spring MVC");
        return "hello"; // WEB-INF/views/hello.jsp
    }
}
