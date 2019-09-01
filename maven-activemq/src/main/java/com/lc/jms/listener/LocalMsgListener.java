package com.lc.jms.listener;

import com.lc.jms.msg.MessagePlatformMsg;
import com.lc.jms.service.ReceiverMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 消息监听
 * 
 */
public class LocalMsgListener {

  @Autowired
  private ReceiverMsgService receiverMsgService;

  public void onMessage(MessagePlatformMsg msg) {
      try {
          receiverMsgService.processMessage(msg);
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}
