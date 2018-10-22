package com.jackie.springbootdemo.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender implements RabbitTemplate.ConfirmCallback {

    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入
     */
    @Autowired
    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

//    public void sendMsg(String content) {
//        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
//        MessagePostProcessor messagePostProcessor = message -> {
//            MessageProperties messageProperties = message.getMessageProperties();
////            设置编码
//            messageProperties.setContentEncoding("utf-8");
////            设置过期时间10*1000毫秒
//            messageProperties.setExpiration("10000");
//            return message;
//        };
//        rabbitTemplate.convertAndSend("DL_EXCHANGE", "DL_KEY", content, messagePostProcessor);
////        rabbitTemplate.convertAndSend("financial.clearing.order.detail.exchange", "", content);
//    }


    public void sendMsg(String content) {
        rabbitTemplate.convertAndSend("demo_exchange", "100", content);
    }

    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + cause);
        }
    }

}