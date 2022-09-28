package com.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * 序列化
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object>redisTemplate(RedisConnectionFactory factory){
         //创建RedisTemplate对象
        RedisTemplate<String, Object> Template = new RedisTemplate<>();
        //创建链接工厂
       Template.setConnectionFactory(factory);
        //创建json序列化
        GenericJackson2JsonRedisSerializer JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        //设置value和key序列化
       Template.setKeySerializer(RedisSerializer.string());
       Template.setHashKeySerializer(RedisSerializer.string());

       Template.setValueSerializer(JsonRedisSerializer);
       Template.setHashValueSerializer(JsonRedisSerializer);
        return Template;
    }
}
