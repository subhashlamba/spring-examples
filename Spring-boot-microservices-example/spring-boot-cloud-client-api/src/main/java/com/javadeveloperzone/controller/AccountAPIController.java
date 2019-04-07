package com.javadeveloperzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Lenovo on 19-07-2017.
 */
@RestController
public class AccountAPIController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/callclient")
    public String callClient() {
        String output = restTemplate.getForObject("http://account-service/account/getAccountDetails",String.class);
        System.out.println(output);
        return output;
    }
}
