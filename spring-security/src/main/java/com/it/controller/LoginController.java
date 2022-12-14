package com.it.controller;

import com.it.domain.User;
import com.it.service.LoginService;
import com.it.util.SystemJsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口
 * @since 2022-9-9
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录接口
     * @param user
     * @return
     */
    @PostMapping("/user/login")
    public SystemJsonResponse login(@RequestBody User user){
        System.out.println("login");
        System.out.println(user);
        return  loginService.login(user);
    }

    /**
     *退出
     */
    @RequestMapping("/user/logout")
    public SystemJsonResponse logout(){
        System.out.println("注销1");
        return loginService.logout();
    }

}
