package com.it.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

    //创建记录日志的对象
   // private  static  final Logger log=  LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public String get(){
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

        return "你好";
    }

}
