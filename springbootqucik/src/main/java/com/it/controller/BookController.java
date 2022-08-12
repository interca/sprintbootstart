package com.it.controller;

import com.it.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {



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
