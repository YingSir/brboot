package com.boransolution.brboot.consumer;

import com.boransolution.brboot.config.RabbitmqProducerConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    private RabbitTemplate rabbitTemplate;
    //    @RabbitListener(queues = "com.boransolution.queue")
    @Autowired
    public MessageConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public Message receiveMessage() {
        Message msg = rabbitTemplate.receive(RabbitmqProducerConfig.QUEUE_NAME);
        return msg;
    }
}
