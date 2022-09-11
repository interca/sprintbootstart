package com.it.handler;

import com.alibaba.fastjson.JSON;
import com.it.util.GlobalResponseCode;
import com.it.util.SystemJsonResponse;
import com.it.util.WebUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 授权失败
 * @since 2022-9-12
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        SystemJsonResponse systemJsonResponse=new SystemJsonResponse
                (GlobalResponseCode.USER_NOT_PERMISSIONS.getCode(),
                        GlobalResponseCode.USER_NOT_PERMISSIONS.getMessage());
        //处理异常
        String s = JSON.toJSONString(systemJsonResponse);
        WebUtil.renderString(response, s);
    }
}
