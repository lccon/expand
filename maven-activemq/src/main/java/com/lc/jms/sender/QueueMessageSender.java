package com.lc.jms.sender;

import com.lc.jms.conventer.LocalMsgConverter;
import com.lc.jms.msg.MessagePlatformMsg;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component("queueMessageSender")
public class QueueMessageSender {

  private JmsTemplate jmsTemplate;
  private ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
  private LocalMsgConverter msgConverter = new LocalMsgConverter();
  private ActiveMQQueue queue;

  private String oldJmsUrl;
  private String oldJmsQueueName;

  public void senderMessage(MessagePlatformMsg messagePlatformMsg) {
    try {
      getTemplate().convertAndSend(messagePlatformMsg);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private JmsTemplate getTemplate() {
    if (null == jmsTemplate || (null != oldJmsUrl && !oldJmsUrl.equals("tcp://127.0.0.1:61616"))
        || (null != oldJmsQueueName && !oldJmsQueueName.equals("jmsQueue01"))) {
      // 配置JMS连接工厂
      setOldJmsUrl("tcp://127.0.0.1:61616");
      setOldJmsQueueName("jmsQueue01");
      connectionFactory.setBrokerURL("tcp://127.0.0.1:61616");
      connectionFactory.setProducerWindowSize(102400000);

      jmsTemplate = new JmsTemplate();
      // 配置JMS模版
      jmsTemplate.setConnectionFactory(connectionFactory);
      jmsTemplate.setSessionTransacted(true);
      queue = new ActiveMQQueue("jmsQueue01");
      jmsTemplate.setDefaultDestination(queue);
      jmsTemplate.setMessageConverter(msgConverter);
    }
    return jmsTemplate;
  }

  private void setOldJmsUrl(String jmsUrl) {
    this.oldJmsUrl = jmsUrl;
  }

  private void setOldJmsQueueName(String jmsQueueName) {
    this.oldJmsQueueName = jmsQueueName;
  }

}
