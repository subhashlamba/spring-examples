package com.javadeveloperzone.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Java Developer Zone on 19-07-2017.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/secure")
    public String secure() {
        return "You are authorize to access this page. This is secure page. ";
    }
    @RequestMapping(value = "/home")
    public String home() {
        return "This is public page. No need of authentication";
    }
}
