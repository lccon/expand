package com.lc.jms.service.impl;

import com.lc.jms.msg.MessagePlatformMsg;
import com.lc.jms.service.ReceiverMsgService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Date:2019/8/30
 * @Author:lc
 */
@Component("receiverMsgService")
public class ReceiverMsgServiceImpl implements ReceiverMsgService{

    @Override
    public void processMessage(MessagePlatformMsg messagePlatformMsg) {
        System.out.println("消费者1已消费:"+messagePlatformMsg.getMessageId());
    }
}
