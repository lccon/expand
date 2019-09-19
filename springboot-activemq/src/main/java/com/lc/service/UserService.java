package com.lc.service;

import com.lc.domain.User;

/**
 * Description:
 *
 * @Date:2019/9/2
 * @Author:lc
 */
public interface UserService {

    /**
     * 存在事务的前提下新增数据并发送mq
     * @return
     */
    User addUser(User user);

    /**
     * 验证是否存在事务
     * @return
     */
    User UpdateUser();

    User getUserById(Long id);

    User getUserByName(String name);
}
