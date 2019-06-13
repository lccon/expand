package com.lc.util;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Description:
 *
 * @Date:2019/6/13
 * @Author:lc
 */
public class RedisUtils {

    private static volatile JedisPool jedisPool = null;

    private RedisUtils() {
    }

    public static JedisPool getJedisPool() {
        if(jedisPool == null) {
            synchronized (RedisUtils.class) {
                if(jedisPool == null) {
                    GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
                    poolConfig.setMaxTotal(10);
                    poolConfig.setMaxIdle(10);
                    poolConfig.setMinIdle(0);
                    poolConfig.setMaxWaitMillis(6000);
                    poolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(poolConfig, "192.168.10.129", 6379);
                }
            }
        }
        return jedisPool;
    }

    public static void release(Jedis jedis) {
        if(jedis != null) {
            jedis.close();
        }
    }

}
