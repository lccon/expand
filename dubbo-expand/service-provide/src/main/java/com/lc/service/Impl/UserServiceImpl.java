package com.lc.service.Impl;

import com.lc.domain.UserAddress;
import com.lc.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @Date:2019/7/14
 * @Author:lc
 */

public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> findUserAddressForList() {
        UserAddress userAddress1 = new UserAddress(1L, "浙江省杭州市", "张三", "13456723343");
        UserAddress userAddress2 = new UserAddress(2L, "河北省石家庄", "李四", "12343355667");
        return Arrays.asList(userAddress1, userAddress2);
    }

}
