package com.lc.service;

import com.lc.domain.UserAddress;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/7/14
 * @Author:lc
 */
public interface UserService {

    List<UserAddress> findUserAddressForList();

}
