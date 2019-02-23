package com.javadeveloperzone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lenovo on 19-07-2017.
 */
@RestController
public class ETagController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello etag Header";
    }
}
