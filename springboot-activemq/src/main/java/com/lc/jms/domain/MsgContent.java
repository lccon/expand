package com.lc.jms.domain;

import java.io.Serializable;

/**
 * Description:
 *
 * @Date:2019/9/2
 * @Author:lc
 */
public class MsgContent implements Serializable {

    private Long msgId;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
}
