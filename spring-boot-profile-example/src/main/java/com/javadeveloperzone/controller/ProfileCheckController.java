package com.javadeveloperzone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@RestController
public class ProfileCheckController {

    @Autowired
    private org.springframework.core.env.Environment environment;

    @GetMapping("/checkProfile")
    public String[] checkProfile() {
        environment.getProperty("app.myname");
        String[] activeProfiles = environment.getActiveProfiles();
        for(String profile:activeProfiles) {
            System.out.print(profile);
        }
        return activeProfiles;
    }
}
