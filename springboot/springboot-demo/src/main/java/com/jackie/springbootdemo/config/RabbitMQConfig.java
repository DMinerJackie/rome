package com.jackie.springbootdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class RabbitMQConfig implements InitializingBean {

    @Autowired
    SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        simpleRabbitListenerContainerFactory.setMessageConverter(new Jackson2JsonMessageConverter());
    }

    @Bean("jackson2JsonMessageConverter")
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ConnectionFactory connectionFactory) {
        return new Jackson2JsonMessageConverter();
    }

    @Bean("rabbitTemplate")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         @Qualifier("jackson2JsonMessageConverter") Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

//    @Bean("deadLetterExchange")
//    public Exchange deadLetterExchange() {
//        return ExchangeBuilder.directExchange("DL_EXCHANGE").durable(true).build();
//    }
//
//    @Bean("deadLetterQueue")
//    public Queue deadLetterQueue() {
//        Map<String, Object> args = new HashMap<>(2);
////       x-dead-letter-exchange    声明  死信交换机
//        args.put("x-dead-letter-exchange", "DL_EXCHANGE");
////       x-dead-letter-routing-key    声明 死信路由键
//        args.put("x-dead-letter-routing-key", "KEY_R");
//        return QueueBuilder.durable("DL_QUEUE").withArguments(args).build();
//    }
//
//    @Bean("redirectQueue")
//    public Queue redirectQueue() {
//        return QueueBuilder.durable("REDIRECT_QUEUE").build();
//    }
//
//    /**
//     * 死信路由通过 DL_KEY 绑定键绑定到死信队列上.
//     *
//     * @return the binding
//     */
//    @Bean
//    public Binding deadLetterBinding() {
//        return new Binding("DL_QUEUE", Binding.DestinationType.QUEUE, "DL_EXCHANGE", "DL_KEY", null);
//
//    }
//
//    /**
//     * 死信路由通过 KEY_R 绑定键绑定到死信队列上.
//     *
//     * @return the binding
//     */
//    @Bean
//    public Binding redirectBinding() {
//        return new Binding("REDIRECT_QUEUE", Binding.DestinationType.QUEUE, "DL_EXCHANGE", "KEY_R", null);
//    }



    // --------------------- 声明队列 ------------------------
    @Bean
    public Queue demoQueue() {
        return new Queue("demo_queue");
    }

    // --------------------- 声明exchange ------------------------

    @Bean
    public DirectExchange demoExchange() {
        return new DirectExchange("demo_exchange");
    }

    // --------------------- 队列绑定 ------------------------
    @Bean
    public Binding bindingAlbumItemCreatedQueue(DirectExchange demoExchange,
                                                Queue demoQueue) {
        return BindingBuilder.bind(demoQueue).to(demoExchange).with("100");
    }

}
