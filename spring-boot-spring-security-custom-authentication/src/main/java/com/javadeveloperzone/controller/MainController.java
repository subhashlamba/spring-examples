package com.javadeveloperzone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lenovo on 19-07-2017.
 */
@Controller
public class MainController {


    @RequestMapping(value = "/login")
    public String SpringBootHello() {
        return "login";
    }

    @RequestMapping(value = "/loginSuccess")
    public String loginSuccess(HttpServletRequest request){

        return "welcome";
    }

    @RequestMapping(value = "/loginFailed")
    public String loginFailed(){
        return "loginFailed";
    }


}
