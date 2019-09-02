package com.lc.controller;

import com.lc.domain.User;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @Date:2019/9/2
 * @Author:lc
 */
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("addUserQueue")
    @ResponseBody
    public User addUserQueue() {
        return userService.addUser();
    }

}
