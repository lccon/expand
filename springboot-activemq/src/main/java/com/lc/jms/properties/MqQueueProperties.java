package com.lc.jms.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Date:2019/9/2
 * @Author:lc
 */
@Component
@ConfigurationProperties("spring.mq.config")
public class MqQueueProperties {

    private String baseQueue;

    public String getBaseQueue() {
        return baseQueue;
    }

    public void setBaseQueue(String baseQueue) {
        this.baseQueue = baseQueue;
    }
}
