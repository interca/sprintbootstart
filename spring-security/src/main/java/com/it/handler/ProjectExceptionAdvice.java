package com.it.handler;

import com.it.Exception.GlobalSystemException;
import com.it.util.SystemJsonResponse;
import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.rmi.server.ServerCloneException;

/**
 * 拦截并且处理异常
 */

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(GlobalSystemException.class)
    public SystemJsonResponse systemJsonResponse(GlobalSystemException systemException){
        System.out.println("ssss");
        return systemException.getSystemJsonResponse();
    }


       @ExceptionHandler(Exception.class)
       public SystemJsonResponse systemJsonResponse2(Exception e){
           System.out.println("exce");
           return SystemJsonResponse.fail(e.getMessage());
        }

        @ExceptionHandler(RuntimeException.class)
        public SystemJsonResponse systemJsonResponse3(RuntimeException e){
            System.out.println("run");
            return SystemJsonResponse.fail(e.getMessage());
        }
}
