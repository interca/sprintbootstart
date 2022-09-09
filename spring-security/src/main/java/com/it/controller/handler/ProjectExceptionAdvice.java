package com.it.controller.handler;

import com.it.Exception.GlobalSystemException;
import com.it.util.SystemJsonResponse;
import org.omg.CORBA.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;
import java.io.IOException;
import java.rmi.server.ServerCloneException;

/**
 * 拦截并且处理异常
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public SystemJsonResponse systemJsonResponse(GlobalSystemException systemException){
        return systemException.getSystemJsonResponse();
    }

    @ExceptionHandler(Exception.class)
    public SystemJsonResponse systemJsonResponse2(Exception e){
        return SystemJsonResponse.fail();
    }

    @ExceptionHandler({RuntimeException.class, ServletException.class, IOException.class})
    public  SystemJsonResponse systemJsonResponse3(RuntimeException r){
        return SystemJsonResponse.fail("操作异常");
    }

}
