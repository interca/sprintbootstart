package com.it.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    @RequestMapping("/hello")
    public  String test(){
        System.out.println(1);
        return "ssss";
    }
}

