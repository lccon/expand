package com.lc;

import com.lc.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemo2ApplicationTests {

	@Test
	public void jedisTest() {
		JedisPool jedisPool = RedisUtils.getJedisPool();
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set("jedis", "pool");
			String jedisData = jedis.get("jedis");
			System.out.println(jedisData);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RedisUtils.release(jedis);
		}
	}

}
