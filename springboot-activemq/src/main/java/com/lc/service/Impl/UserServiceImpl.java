package com.lc.service.Impl;

import com.lc.domain.User;
import com.lc.jms.domain.MsgContent;
import com.lc.mapper.UserMapper;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lc.jms.JmsSender;

/**
 * Description:
 *
 * @Date:2019/9/2
 * @Author:lc
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JmsSender JmsSender;

    public User addUser() {
        User user = new User();
        user.setName("李四");
        user.setAge(15);
        userMapper.addUser(user);

        MsgContent msgContent = new MsgContent();
        msgContent.setMsgId(user.getId());
        JmsSender.sendMessage(msgContent);
        return user;
    }

    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }
}
