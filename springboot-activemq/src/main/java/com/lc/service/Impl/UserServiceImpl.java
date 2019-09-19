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

    public User addUser(User user) {
        userMapper.addUser(user);

        MsgContent msgContent = new MsgContent();
        msgContent.setMsgId(user.getId());
        JmsSender.sendMessage(msgContent);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User UpdateUser() {
        userMapper.updateUser(new User(11L, 200));
        userMapper.updateUser(new User(12L, 1000));
        return getUserById(11L);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }


}
