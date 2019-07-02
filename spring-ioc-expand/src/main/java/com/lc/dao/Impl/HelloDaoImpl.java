package com.lc.dao.Impl;

import com.lc.dao.HelloDao;

/**
 * Description:
 *
 * @Date:2019/7/2
 * @Author:lc
 */
public class HelloDaoImpl implements HelloDao {

    @Override
    public String sayHello() {
        return "hello world";
    }

}
