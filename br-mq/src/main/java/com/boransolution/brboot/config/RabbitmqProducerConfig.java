package com.boransolution.brboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqProducerConfig {
    public static final String EXCHANGE = "com.boransolution.exchange"; 	// 交换空间名称
    public static final String ROUTING_KEY = "com.boransolution.routingKey"; // 设置路由key
    public static final String QUEUE_NAME = "com.boransolution.queue"; 	// 队列名称
    @Bean
    public Binding bindingExchangeQueue(DirectExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY) ;
    }
    @Bean
    public DirectExchange getDirectExchange() { 						// 使用直连的模式
        return new DirectExchange(EXCHANGE, true, true);
    }
    @Bean
    public Queue queue() { 											// 队列信息
        return new Queue(QUEUE_NAME);
    }

}
