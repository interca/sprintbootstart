package com.it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringDataRedisApplicationTests {

	//@Qualifier("stringRedisTemplate")


	@Autowired
	private RedisTemplate<String,Object>template;
	@Test
	void contextLoads() {
		//template.opsForValue().set("p",new User("hyj",12));
		 //template.opsForValue().set("name",new User("HYJ",12));
		Object name = template.opsForValue().get("name");
		System.out.println(name);
	}

}
