package com.securitystart.hello;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/dba", method = RequestMethod.GET)
    public String dbaPage(Model model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "hello";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(Model model) {
        model.addAttribute("user", getPrincipal());
        return "accessdenied";
    }

    private String getPrincipal() {
        String username = null;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
            username = ((UserDetails)principal).getUsername();
        else
            username = principal.toString();

        return username;
    }
}
