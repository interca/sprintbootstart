package com.it;

import com.it.domain.User;
import com.it.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }

    @Test
    void test2(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        //对密码进行加密
        String encode = passwordEncoder.encode("1234");
        System.out.println(passwordEncoder.matches("1234",encode));

    }

}
