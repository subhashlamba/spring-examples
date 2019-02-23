package com.javadeveloperzone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginSuccess")
    public String loginSuccess(Principal principal, ModelMap modelMap) {
        modelMap.put("userName",principal.getName());
        return "welcome";
    }

    @RequestMapping(value = "/loginFailed")
    public String loginFailed() {
        return "loginFailed";
    }
}
