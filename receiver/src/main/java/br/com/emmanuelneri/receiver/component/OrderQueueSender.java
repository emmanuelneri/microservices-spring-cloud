package br.com.emmanuelneri.receiver.component;

import br.com.emmanuelneri.receiver.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.HashMap;
import java.util.Map;

@Component
public class OrderQueueSender {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void send(Order order) {
        final Map<String, Object> headers = createHeader(order);
        this.jmsMessagingTemplate.convertAndSend(this.queue, order.getBody(), headers);
    }

    private Map<String, Object> createHeader(Order order) {
        final Map<String, Object> headers = new HashMap<>();
        headers.put("id", order.getId());
        return headers;
    }
}
