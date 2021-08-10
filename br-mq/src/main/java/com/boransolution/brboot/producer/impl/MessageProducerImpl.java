    package com.boransolution.brboot.producer.impl;

    import com.boransolution.brboot.config.RabbitmqProducerConfig;
    import com.boransolution.brboot.producer.IMessageProducer;
    import org.springframework.amqp.rabbit.core.RabbitTemplate;
    import org.springframework.stereotype.Service;

    import javax.annotation.Resource;

    @Service
    public class MessageProducerImpl implements IMessageProducer {
        @Resource
        private RabbitTemplate rabbitTemplate;

        @Override
        public void send(String msg) {
            this.rabbitTemplate.convertAndSend(RabbitmqProducerConfig.EXCHANGE,
                    RabbitmqProducerConfig.ROUTING_KEY,
                    msg);
        }
    }
