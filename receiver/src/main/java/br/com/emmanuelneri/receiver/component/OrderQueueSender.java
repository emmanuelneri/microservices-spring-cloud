package br.com.emmanuelneri.receiver.component;

import br.com.emmanuelneri.receiver.model.OrderFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderQueueSender {

    private static final String HEADER_PROPERTY_ID = "id";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(OrderFile order) {
        rabbitTemplate.convertAndSend(this.queue.getName(), order.getBody(), messagePostProcessor -> {
            messagePostProcessor.getMessageProperties().setHeader(HEADER_PROPERTY_ID, order.getId());
            return messagePostProcessor;
        });
        log.info("Order sent to queue - {}", order);
    }
}
