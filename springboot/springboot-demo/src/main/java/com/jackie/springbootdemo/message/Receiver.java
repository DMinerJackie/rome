package com.jackie.springbootdemo.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "demo_queue")
    public void created(String message) {
        System.out.println("orignal message: " + message);
    }

}


