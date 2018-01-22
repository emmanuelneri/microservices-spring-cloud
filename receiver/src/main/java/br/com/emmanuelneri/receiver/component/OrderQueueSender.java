package br.com.emmanuelneri.receiver.component;

import br.com.emmanuelneri.receiver.model.Order;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueSender {

    private static final String HEADER_PROPERTY_ID = "id";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Order order) {
        rabbitTemplate.convertAndSend(this.queue.getName(), order.getBody(), messagePostProcessor -> {
            messagePostProcessor.getMessageProperties().setHeader(HEADER_PROPERTY_ID, order.getId());
            return messagePostProcessor;
        });
    }
}
