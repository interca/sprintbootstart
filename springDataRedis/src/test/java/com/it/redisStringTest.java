package com.it;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class redisStringTest {
    @Autowired
    private StringRedisTemplate redisTemplate;



    private static  final  ObjectMapper objectMapper=new ObjectMapper();
    @Test
    void test(){
        redisTemplate.opsForValue().set("name2","hyj");

    }

    @Test
    void test2() throws JsonProcessingException {
        User yh = new User("yh", 20);
        //手动序列化
        String s = objectMapper.writeValueAsString(yh);
        //写入数据
        redisTemplate.opsForValue().set("user:100",s);
        String s1 = redisTemplate.opsForValue().get("user:100");
        User user = objectMapper.readValue(s1, User.class);
        System.out.println(user);
    }
}
