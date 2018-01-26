package br.com.emmanuelneri.receiver.service;

import br.com.emmanuelneri.receiver.component.OrderQueueSender;
import br.com.emmanuelneri.receiver.model.OrderFile;
import br.com.emmanuelneri.receiver.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderQueueSender orderQueueSender;

    public void receive(String origin, String order) {
        final OrderFile orderSaved = save(origin, order);
        orderQueueSender.send(orderSaved);
    }

    private OrderFile save(String origin, String order) {
        return orderRepository.save(new OrderFile(origin, order));
    }
}
