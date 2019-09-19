package com.lc.jms;

import com.alibaba.fastjson.JSON;
import com.lc.domain.User;
import com.lc.jms.domain.MsgContent;
import com.lc.mapper.UserMapper;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Date:2019/9/2
 * @Author:lc
 */
@Component
public class JmsReceiver {

    @Autowired
    private UserService userService;

    @JmsListener(destination = "baseQueue02")
    public void receivedUserMessage(String jmsMessage) {
        MsgContent msgContent = JSON.parseObject(jmsMessage, MsgContent.class);
        // User user = userService.getUserById(msgContent.getMsgId());
        User user = userService.getUserByName("AA");

        System.out.println("消费者已消费:"+JSON.toJSONString(user));
    }

}
