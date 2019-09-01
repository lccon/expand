package com.lc.jms.conventer;

import com.lc.jms.msg.MessagePlatformMsg;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;


/**
 * 消息转换
 * 
 */
public class LocalMsgConverter implements MessageConverter {

  @Override
  public Object fromMessage(Message message) throws JMSException, MessageConversionException {
    MapMessage msg = (MapMessage) message;
    return createMessagePlatformMsg(msg);
  }

  @Override
  public Message toMessage(Object object, Session session)
      throws JMSException, MessageConversionException {
    MapMessage mapMessage = session.createMapMessage();
    return convertMessagePlatformMsg(mapMessage, object);
  }

  private Object createMessagePlatformMsg(MapMessage msg) throws JMSException {
    MessagePlatformMsg messagePlatformMsg = new MessagePlatformMsg();
    try {
      messagePlatformMsg
              .setMessageId(msg.getLong("messageId"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return messagePlatformMsg;
  }

  private MapMessage convertMessagePlatformMsg(MapMessage mapMessage, Object object)
          throws JMSException {
    MessagePlatformMsg messagePlatformMsg = (MessagePlatformMsg) object;
    mapMessage.setLong("messageId", messagePlatformMsg.getMessageId());
    return mapMessage;
  }

}
