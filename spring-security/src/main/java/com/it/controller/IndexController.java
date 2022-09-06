package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {
    @RequestMapping("/login")
    public  String test(){
        System.out.println(1);
        return "redirect:main.html";
    }
}
