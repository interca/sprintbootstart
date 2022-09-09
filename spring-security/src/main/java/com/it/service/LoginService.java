package com.it.service;

import com.it.domain.User;
import com.it.util.SystemJsonResponse;

/**
 * 登录接口的service
 */
public interface LoginService {

    SystemJsonResponse login(User user);
}
