package com.lc.service.Impl;

import com.lc.jms.msg.MessagePlatformMsg;
import com.lc.jms.sender.QueueMessageSender;
import com.lc.jms.sender.TopicMessageSender;
import com.lc.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Date:2019/8/30
 * @Author:lc
 */
@Service("textService")
public class TextServiceImpl implements TextService {

    @Autowired
    private QueueMessageSender queueMessageSender;
    @Autowired
    private TopicMessageSender topicMessageSender;

    @Override
    public Boolean getQueueState() {
        MessagePlatformMsg messagePlatformMsg = new MessagePlatformMsg();
        for (int i = 1; i <= 10; i++) {
            messagePlatformMsg.setMessageId(Long.valueOf(i));
            queueMessageSender.senderMessage(messagePlatformMsg);
        }
        return true;
    }

    @Override
    public Boolean getTopicState() {
        MessagePlatformMsg messagePlatformMsg = new MessagePlatformMsg();
        for (int i = 1; i <= 10; i++) {
            messagePlatformMsg.setMessageId(Long.valueOf(i));
            topicMessageSender.senderMessage(messagePlatformMsg);
        }
        return true;
    }
}
