/**
 * RabbitMessageHandler.java
 *
 * Copyright (c) 2013 by efubao.com.
 */
package com.efubao.core.common.mq.rabbit;

/**
 * 客户端的消息处理接口
 *
 */
public interface RabbitSubscriberMessageHandler {
    /**
     * 处理消息
     *
     * @param message 消息
     */
    void handleMessage(Object message);
}
