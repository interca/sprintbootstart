package com.it;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.domain.User;
import com.it.mapper.MenuMapper;
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

    @Autowired
    private MenuMapper menuMapper;
    @Test
    void contextLoads() {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,"黄裕甲");
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    void test2(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        //对密码进行加密
        String encode = passwordEncoder.encode("123");
        System.out.println(encode);
    }

    @Test
    void  test3(){
        System.out.println(menuMapper.selectPermsByUserId(2L));
    }

}
