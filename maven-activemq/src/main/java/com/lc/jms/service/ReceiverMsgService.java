package com.lc.jms.service;

import com.lc.jms.msg.MessagePlatformMsg;

/**
 * 消息表服务
 */
public interface ReceiverMsgService {


  void processMessage(MessagePlatformMsg messagePlatformMsg);

}
