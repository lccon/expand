package com.example.demo.controller;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

/**
 * Description:
 *
 * @Date:2019/6/12
 * @Author:lc
 */
@Controller
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("setRedis")
    @ResponseBody
    public Boolean setTest() {
        redisService.set("14", "秦皇岛");
        return true;
    }

}
