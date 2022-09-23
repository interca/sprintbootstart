package com.it;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class Redis1ApplicationTests {

    private Jedis jedis;
    @Test
    void contextLoads() {
        //建立链接
       jedis=new Jedis("192.168.83.128",6379);
       //密码
        jedis.auth("13538026482huang");
        jedis.select(0);
        String set = jedis.set("nx", "hyj");
        System.out.println(set);
        String nx = jedis.get("nx");
        System.out.println(nx);
        if(jedis!=null)jedis.close();
    }
    @Test
    void contextLoads2() {
        //建立链接
        jedis=new Jedis("192.168.83.128",6379);
        //密码
        jedis.auth("13538026482huang");
        jedis.select(0);
         jedis.hset("student:1","math","100");
        String math = jedis.hget("student:1", "math");
        System.out.println(math);
        jedis.close();
    }

     @Test
    void test3(){
        jedis=JedisConnectionFactory.getJedis();
        jedis.hset("student:1","chinese","hyj");
         System.out.println(jedis.hget("student:1", "math"));
     }
}
