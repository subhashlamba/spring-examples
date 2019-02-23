package com.javadeveloperzone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lenovo on 19-07-2017.
 */
@RestController
public class SpringBootExampleController {

    @RequestMapping("/")
    public String SpringBootHello() {
        return "Spring Boot Example";
    }

    @RequestMapping("/404")
    public String ErrorPage404() {
        return "404";
    }
}
