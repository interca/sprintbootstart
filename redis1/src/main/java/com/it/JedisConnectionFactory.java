package com.it;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis连接池
 */
public class JedisConnectionFactory {
     private  static  final JedisPool jedispool;
     static {
         JedisPoolConfig poolConfig = new JedisPoolConfig();
         //最大连接数
         poolConfig.setMaxTotal(8);
         poolConfig.setMaxIdle(8);
         poolConfig.setMinIdle(0);
         //等待时长
         poolConfig.setMaxWaitMillis(1000);
         jedispool=new JedisPool(poolConfig,"192.168.83.128",
                 6379,1000,"13538026482huang");
     }

     public  static Jedis getJedis(){
         return jedispool.getResource();
     }

}
