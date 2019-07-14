package com.lc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Description:
 *
 * @Date:2019/7/14
 * @Author:lc
 */
public class providerConfig {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-dubbo.xml");
        context.start();
        System.in.read(); // 按任意键退出
    }
}
