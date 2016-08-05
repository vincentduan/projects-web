/**
 * DefaultRabbitMessageHandler.java
 *
 * Copyright (c) 2013 by efubao.com.
 */
package com.efubao.core.common.mq.rabbit;

/**
 * 客户端的消息处理接口的默认实现.具体应用需要自己实现RabbitMessageHandler接口.
 *
 */
public class DefaultRabbitSubscriberMessageHandler implements RabbitSubscriberMessageHandler {

    @Override
    public final void handleMessage(final Object message) {
        System.out.println(">>>message type:" + message.getClass().getName());
        System.out.println(">>>received message:" + message.toString());
    }

}
