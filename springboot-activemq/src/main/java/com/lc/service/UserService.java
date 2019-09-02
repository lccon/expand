package com.lc.service;

import com.lc.domain.User;

/**
 * Description:
 *
 * @Date:2019/9/2
 * @Author:lc
 */
public interface UserService {

    User addUser();

    User getUserById(Long id);
}
