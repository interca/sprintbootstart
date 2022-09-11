package com.it.handler;

import com.alibaba.fastjson.JSON;
import com.it.Exception.GlobalSystemException;
import com.it.util.GlobalResponseCode;
import com.it.util.SystemJsonResponse;
import com.it.util.WebUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证全局异常处理
 * @since 2022-9-12
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        SystemJsonResponse systemJsonResponse=new SystemJsonResponse
                (GlobalResponseCode.USER_ACCOUNT_PASSWORD_Error.getCode(),
                        GlobalResponseCode.USER_ACCOUNT_PASSWORD_Error.getMessage());
        String s = JSON.toJSONString(systemJsonResponse);
        //处理异常
        WebUtil.renderString(response, s);
    }
}
