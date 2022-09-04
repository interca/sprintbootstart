package com.it.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//springmvc异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //拦截所有异常
    @ExceptionHandler
    public R doException(Exception e){
         return new R(false,"服务器故障，稍后再试");
    }
}
