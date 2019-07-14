package com.lc.controller;

import com.lc.domain.UserOrder;
import com.lc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @Date:2019/7/14
 * @Author:lc
 */
@Controller
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/getUserOrder")
    @ResponseBody
    public UserOrder getUserOrder() {
        return orderService.getUserOrder();
    }

}
