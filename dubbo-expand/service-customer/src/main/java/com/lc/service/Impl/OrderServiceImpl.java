package com.lc.service.Impl;

import com.lc.domain.UserAddress;
import com.lc.domain.UserOrder;
import com.lc.service.OrderService;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/7/14
 * @Author:lc
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    @Override
    public UserOrder getUserOrder() {

        UserOrder userOrder = new UserOrder();
        userOrder.setId(1L);
        userOrder.setGoods("电视机");
        userOrder.setPrice(1300L);

        List<UserAddress> userAddressForList = userService.findUserAddressForList();
        userOrder.setUserAddressList(userAddressForList);
        return userOrder;
    }

}
