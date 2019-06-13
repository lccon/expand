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

	@Test
	public void hsetTest() {
		Jedis jedis = null;
		try {
			JedisPool jedisPool = RedisUtils.getJedisPool();
			jedis = jedisPool.getResource();
			jedis.hset("user", "id", "20");
			jedis.hset("user", "name", "李四");
			String uid = jedis.hget("user", "id");
			String uname = jedis.hget("user", "name");
			System.out.println(uid);
			System.out.println(uname);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RedisUtils.release(jedis);
		}
	}

	@Test
	public void lpushTest() {
		Jedis jedis = null;
		try {
			JedisPool jedisPool = RedisUtils.getJedisPool();
			jedis = jedisPool.getResource();
			jedis.lpush("list01", "1", "2", "3", "4", "5", "6");
			String list01 = jedis.lpop("list01");
			System.out.println(list01);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RedisUtils.release(jedis);
		}
	}
}
