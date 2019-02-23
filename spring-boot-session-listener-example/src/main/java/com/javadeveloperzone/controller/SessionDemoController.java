package com.javadeveloperzone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@RestController
public class SessionDemoController {

    @GetMapping("/viewSessionData")                     // it will handle all request for /viewSessionData
    public java.util.Map<String, Integer> start(HttpServletRequest request) {
        Integer integer = (Integer) request.getSession()
                                           .getAttribute("hitCounter");        // create session if not exists and get attribute
        if (integer == null) {
            integer = new Integer(0);
            integer++;
            request.getSession().setAttribute("hitCounter", integer);           // replace session attribute
        } else {
            integer++;
            request.getSession().setAttribute("hitCounter", integer);            // replace session attribute
        }
        java.util.Map<String, Integer> hitCounter = new HashMap<>();
        hitCounter.put("Hit Counter", integer);
        return hitCounter;
    }

}
