package com.lc.service;

/**
 * Description:
 *
 * @Date:2019/8/30
 * @Author:lc
 */
public interface TextService {
    /**
     * 点对点
     * @return
     */
    Boolean getQueueState();

    /**
     * 发布/订阅
     * @return
     */
    Boolean getTopicState();
}
