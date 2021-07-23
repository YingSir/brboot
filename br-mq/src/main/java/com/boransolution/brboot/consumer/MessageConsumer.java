package com.boransolution.brboot.consumer;

import com.boransolution.brboot.config.RabbitmqProducerConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public Message receiveMessage() {
        Message msg = rabbitTemplate.receive(RabbitmqProducerConfig.QUEUE_NAME);
        return msg;
    }

    /**
     * 通过注解声明要监听订单消息，而不是使用RabbitTemplate进行轮询。
     */
    @RabbitListener(queues = "com.boransolution.queue")
    public void listeningMessage(String msg) {
        System.out.println(msg);
    }
}
