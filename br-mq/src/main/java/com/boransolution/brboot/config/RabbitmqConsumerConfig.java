package com.boransolution.brboot.config;

/**
 * 作为服务端已经配置了:RabbitmqProducerConfig

@Configuration
public class RabbitmqConsumerConfig {
    public static final String EXCHANGE = "com.boransolution.exchange"; 	// 交换空间名称
    public static final String ROUTING_KEY = "com.boransolution.routingKey"; // 设置路由key
    public static final String QUEUE_NAME = "com.boransolution.queue"; 	// 队列名称
    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME);
    }
    @Bean
    public DirectExchange getDirectExchange(){
        return new DirectExchange(EXCHANGE,true,true);
    }
    @Bean
    public Binding bindingExchangeQueue(DirectExchange exchange,Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
 */