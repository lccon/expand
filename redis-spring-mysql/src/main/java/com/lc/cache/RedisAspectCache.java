package com.lc.cache;

import com.alibaba.fastjson.JSON;
import com.lc.domain.Site;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.Serializable;

/**
 * Description:
 *
 * @Date:2020/5/26
 * @Author:lc
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class RedisAspectCache {

    private static final String POINT_ADD = "execution(* com.lc.service.Impl.SiteServiceImpl.insert*(..))";
    private static final String POINT_UPDATE = "execution(* com.lc.service.Impl.SiteServiceImpl.updateSite(..))";
    private static final String POINT_DELETE = "execution(* com.lc.service.Impl.SiteServiceImpl.deleteSite(..))";
    private static final String POINT_GETONE = "execution(* com.lc.service.Impl.SiteServiceImpl.getSiteById(..))";

    private static final String PREFIX = "site:";
    
    @Autowired
    private JedisPool jedisPool;
    
    @Around(value = POINT_ADD)
    public Object cacheAddSite(ProceedingJoinPoint point) throws Throwable {
        // 放行，先插入数据库
        Site site = (Site)point.proceed();
        Jedis jedis = jedisPool.getResource();

        String siteStr = JSON.toJSONString(site);
        jedis.set(PREFIX + site.getId(), siteStr);
        jedis.close();
        return site;
    }

    @Around(value = POINT_UPDATE)
    public Object cacheUpdateSite(ProceedingJoinPoint point) throws Throwable {
        // 放行，先修改数据库
        Site site = (Site)point.proceed();
        if (site != null && site.getId() != null) {
            Jedis jedis = jedisPool.getResource();

            String siteStr = JSON.toJSONString(site);
            jedis.set(PREFIX + site.getId(), siteStr);
            jedis.close();
        }
        return site;
    }

    @Around(value = POINT_DELETE)
    public Object cacheDeleteSite(ProceedingJoinPoint point) throws Throwable {

        Serializable id = (Serializable)point.getArgs()[0];
        Jedis jedis = jedisPool.getResource();
        if (jedis.exists(PREFIX + id)) {
            jedis.del(PREFIX + id);
        }
        jedis.close();
        // 放行，先删除数据库
        Integer count = (Integer)point.proceed();
        return count > 0;
    }

    @Around(value = POINT_GETONE)
    public Object cacheGetSite(ProceedingJoinPoint point) throws Throwable {
        Serializable id = (Serializable)point.getArgs()[0];
        if (id == null) {
            return null;
        }
        Jedis jedis = jedisPool.getResource();
        String siteStr = jedis.get(PREFIX + id);
        Site site = null;
        if (siteStr != null) {
            site = JSON.parseObject(siteStr, Site.class);
            return site;
        } else {
            site = (Site)point.proceed();
            if (site != null) {
                jedis.set(PREFIX+site.getId(), JSON.toJSONString(site));
            }
        }
        jedis.close();
        return site;
    }

}
