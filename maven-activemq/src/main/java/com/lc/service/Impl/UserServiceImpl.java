package com.lc.service.Impl;

import com.lc.domain.User;
import com.lc.jms.msg.MessagePlatformMsg;
import com.lc.jms.sender.QueueMessageSender;
import com.lc.mapper.UserMapper;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Date:2019/9/1
 * @Author:lc
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QueueMessageSender queueMessageSender;

    public User addUser() {
        User user = new User();
        user.setName("张三");
        user.setAge(14);
        userMapper.addUser(user);
        MessagePlatformMsg messagePlatformMsg = new MessagePlatformMsg();
        messagePlatformMsg.setMessageId(user.getId());
        queueMessageSender.senderMessage(messagePlatformMsg);
        return user;
    }

}
