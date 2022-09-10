package com.it.service;

import com.it.domain.User;
import com.it.util.SystemJsonResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录接口的service
 */
public interface LoginService {

    /**
     * 登录
     * @param user
     * @return
     */
    SystemJsonResponse login(User user) ;

    /**
     * 退出登录
     * @return
     */
    SystemJsonResponse logout();
}
