package com.it.controller;

import com.it.domain.User;
import com.it.service.LoginService;
import com.it.util.SystemJsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口
 * @since 2022-9-9
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public SystemJsonResponse login(@RequestBody User user){
        SystemJsonResponse login = loginService.login(user);
        System.out.println("方法");
        return  login;
    }
}
