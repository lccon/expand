package com.lc;

import com.lc.dao.HelloDao;
import com.lc.dao.Impl.HelloDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 *
 * @Date:2019/7/2
 * @Author:lc
 */
public class HelloTest {

    @Test
    public void sayHello() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        HelloDao helloDao = ac.getBean(HelloDao.class);
        System.out.println(helloDao.sayHello());
    }

}
