package com.it.controller;

import com.it.domain.MyDataSource;
import com.it.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {


    //读取数据
    @Value("${country}")
    private String country1;

    //两级数据
    @Value("${user1.name}")
    private String name;

    //读数组中数据
    @Value("${likes[0]}")
    private  String like1l;

    @Autowired
    private Environment environment;

    @Autowired
    private MyDataSource myDataSource;
    @RequestMapping("/test1")
    public  void test1(){
        System.out.println(country1);
        System.out.println(name);
        System.out.println(like1l);
        System.out.println(environment.getProperty("country"));
        System.out.println(myDataSource);
    }


    //@RequestMapping(value = "/users",method = RequestMethod.GET)
    @GetMapping
    public User findAll(){
        User user=new User();
        user.setId(100);
        user.setName("Huan裕甲");
        return  user;
    }
    
    @GetMapping("/findall/{id}")
    public int findbyId(@PathVariable int id){
        return  id;
    }
}
