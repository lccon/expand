package com.example.demo.config;

import com.example.demo.service.Impl.RedisServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Description:
 *
 * @Date:2019/6/12
 * @Author:lc
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfigure {

    private RedisProperties redisProperties;

    public RedisConfigure(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    @Bean
    public JedisPoolConfig configureJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisProperties.getMaxActive());
        jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
        jedisPoolConfig.setMinIdle(redisProperties.getMinIdle());
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getMaxWait());
        jedisPoolConfig.setTestOnBorrow(redisProperties.isTestOnBorrow());
        return jedisPoolConfig;
    }

    @Bean
    public JedisConnectionFactory getConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setUsePool(true);
        JedisPoolConfig jedisPoolConfig = configureJedisPoolConfig();
        factory.setPoolConfig(jedisPoolConfig);
        factory.setHostName(redisProperties.getHost());
        factory.setPort(redisProperties.getPort());
        factory.setTimeout(redisProperties.getTimeOut());
        factory.setDatabase(redisProperties.getDatabase());
        return factory;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<?, ?> redisTemplate() {
        JedisConnectionFactory factory = getConnectionFactory();
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        initRedisTemplate(redisTemplate, factory);
        return redisTemplate;
    }

    private void initRedisTemplate(RedisTemplate<String, Object> redisTemplate, JedisConnectionFactory jedisConnectionFactory) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 开启事务
        redisTemplate.setEnableTransactionSupport(false);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        //--
        redisTemplate.afterPropertiesSet();
    }

    @Bean(name = "redisService")
    public RedisServiceImpl createRedisService() {
        RedisServiceImpl redisServiceImpl = new RedisServiceImpl();
        return redisServiceImpl;
    }

}
