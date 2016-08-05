/**
 * RabbitMessageService.java
 *
 * Copyright (c) 2013 by efubao.com.
 */
package com.efubao.core.common.mq.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.utils.SerializationUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * message publish service.
 * 构造函数注入
 *
 */
public class RabbitPublisherService {
    /**
     * 构造函数创建RabbitTemplate实例.
     */
    private RabbitTemplate template;

//    @Resource(name = "retryTemplate")
//    private RetryTemplate retryTemplate;

    /**
     * default contractor for CGLIB
     */
    public RabbitPublisherService() {

    }

    /**
     * constructor
     *
     * @param connectionFactory connection工厂
     * @param exchange          交换器
     */
    public RabbitPublisherService(final ConnectionFactory connectionFactory, final String exchange) {
        this.template = new RabbitTemplate(connectionFactory);
        this.template.setExchange(exchange);
        this.template.setMessageConverter(new JsonMessageConverter());
//        this.template.setRetryTemplate(retryTemplate);
    }

    /**
     * 发布消息,根据routingKey路由到各队列.
     * routingKey若为队列名集合，如："queue1.queue2"，消息就会被发送到名为queue1和queue2的两个消息队列
     *
     * @param routingKey 路由key
     * @param message    消息实例(message类必须有空构造器)
     */
    public void send(String routingKey, Object message) {
        template.convertAndSend(routingKey, message);
    }

    /**
     * 发布消息, es专用
     * 根据routingKey路由到各队列.
     * routingKey若为队列名集合，如："queue1.queue2"，消息就会被发送到名为queue1和queue2的两个消息队列
     *
     * @param routingKey 路由key
     * @param message    消息字符串
     */
    public void send(String routingKey, String message) {
        template.send(routingKey, createMessage(message, new MessageProperties()));
    }

    /**
     * Creates an AMQP Message from the provided Object.
     */
    protected Message createMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        byte[] bytes = null;
        if (object instanceof byte[]) {
            bytes = (byte[]) object;
            messageProperties.setContentType(MessageProperties.CONTENT_TYPE_BYTES);
        } else if (object instanceof String) {
            try {
                bytes = ((String) object).getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new MessageConversionException(
                        "failed to convert to Message content", e);
            }
            messageProperties.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN);
            messageProperties.setContentEncoding("UTF-8");
        } else if (object instanceof Serializable) {
            try {
                bytes = SerializationUtils.serialize(object);
            } catch (IllegalArgumentException e) {
                throw new MessageConversionException(
                        "failed to convert to serialized Message content", e);
            }
            messageProperties.setContentType(MessageProperties.CONTENT_TYPE_SERIALIZED_OBJECT);
        }
        if (bytes != null) {
            messageProperties.setContentLength(bytes.length);
        }
        return new Message(bytes, messageProperties);
    }

}
