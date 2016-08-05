/**
 * RabbitConsumerConfiguration.java
 *
 * Copyright (c) 2013 by efubao.com.
 */
package com.efubao.core.common.mq.rabbit;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.JsonMessageConverter;

/**
 * 消息监听.
 * <pre>
 * Spring构造器注入。
 * 在spring XML配置文件中配置一个实例就可以启动一个监听实例，需要监听多个队列或者配置不同的handler时只需多配置几个实例即可
 * </pre>
 *
 */
public class RabbitSubscriberConfiguration extends SimpleMessageListenerContainer {

    /**
     * constructor
     *
     * @param connectionFactory connection工厂
     * @param queueName         队列名称
     * @param messageHandler    消息处理接口
     */
    public RabbitSubscriberConfiguration(ConnectionFactory connectionFactory, String queueName,
                                         RabbitSubscriberMessageHandler messageHandler) {
        super.setConnectionFactory(connectionFactory);
        super.setQueueNames(queueName);
        super.setMessageListener(new MessageListenerAdapter(messageHandler,
                new JsonMessageConverter()));
    }

    /**
     * constructor
     *
     * @param connectionFactory connection工厂
     * @param messageHandler    消息处理接口
     * @param queueNames        队列名称
     */
    public RabbitSubscriberConfiguration(ConnectionFactory connectionFactory,
                                         RabbitSubscriberMessageHandler messageHandler, String... queueNames) {
        super.setConnectionFactory(connectionFactory);
        super.setQueueNames(queueNames);
        super.setMessageListener(new MessageListenerAdapter(messageHandler,
                new JsonMessageConverter()));
    }

    /**
     * constructor
     *
     * @param connectionFactory      connection工厂
     * @param messageListenerAdapter 消息监听适配器
     * @param queueNames             队列名称s
     */
    public RabbitSubscriberConfiguration(ConnectionFactory connectionFactory,
                                         MessageListenerAdapter messageListenerAdapter, String... queueNames) {
        super.setConnectionFactory(connectionFactory);
        super.setMessageListener(messageListenerAdapter);
        super.setQueueNames(queueNames);
    }

}
