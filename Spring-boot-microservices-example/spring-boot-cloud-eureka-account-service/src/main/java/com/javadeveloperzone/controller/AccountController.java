package com.javadeveloperzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Lenovo on 19-07-2017.
 */
@RestController
public class AccountController {

    @Autowired
    private Environment environment;

    @RequestMapping("/getAccountDetails")
    public String callClient() {
        return "This response from : " + environment.getProperty("server.port");
    }
}
