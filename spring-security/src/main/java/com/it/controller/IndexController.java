package com.it.controller;


import com.it.util.SystemJsonResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    @PostMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public SystemJsonResponse test(){
        System.out.println(SystemJsonResponse.success());return SystemJsonResponse.success();
    }
}

