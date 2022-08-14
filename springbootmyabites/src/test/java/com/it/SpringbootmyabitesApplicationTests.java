package com.it;

import com.it.Mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootmyabitesApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper.getById(1));
    }

}
