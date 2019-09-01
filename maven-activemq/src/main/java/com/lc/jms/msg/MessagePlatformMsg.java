package com.lc.jms.msg;

import java.io.Serializable;

/**
 * 
 * 自己消费的消息
 * 
 */
public class MessagePlatformMsg implements Serializable{

  private static final long serialVersionUID = 1L;
  /** 数据库消息表的 ID号 */
  private Long messageId;

  public Long getMessageId() {
    return messageId;
  }

  public void setMessageId(Long messageId) {
    this.messageId = messageId;
  }

}
