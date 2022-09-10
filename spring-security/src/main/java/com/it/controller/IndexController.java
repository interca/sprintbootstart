package com.it.controller;


import com.it.util.SystemJsonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    @PostMapping("/hello")
    public SystemJsonResponse test(){
        System.out.println(SystemJsonResponse.success());return SystemJsonResponse.success();
    }
}

