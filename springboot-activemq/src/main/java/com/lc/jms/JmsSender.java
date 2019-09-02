package com.lc.jms;

import com.alibaba.fastjson.JSON;
import com.lc.jms.domain.MsgContent;
import com.lc.jms.properties.MqQueueProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Date:2019/9/2
 * @Author:lc
 */
@Component
public class JmsSender {

    @Autowired
    private MqQueueProperties mqQueueProperties;
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    public void sendMessage(MsgContent msgContent) {
        jmsTemplate.convertAndSend(mqQueueProperties.getBaseQueue(), JSON.toJSONString(msgContent));
    }

}
