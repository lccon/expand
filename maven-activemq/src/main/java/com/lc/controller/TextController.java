package com.lc.controller;

import com.lc.domain.User;
import com.lc.service.TextService;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @Date:2019/8/30
 * @Author:lc
 */
@Controller
@RequestMapping("/api")
public class TextController {

    @Autowired
    private TextService textService;
    @Autowired
    private UserService userService;

    @RequestMapping("getQueueState")
    @ResponseBody
    public Boolean getQueueState() {
        return textService.getQueueState();
    }

    @RequestMapping("getTopicState")
    @ResponseBody
    public Boolean getTopicState() {
        return textService.getTopicState();
    }

    @RequestMapping("addUser")
    @ResponseBody
    public User addUser() {
        return userService.addUser();
    }

}
