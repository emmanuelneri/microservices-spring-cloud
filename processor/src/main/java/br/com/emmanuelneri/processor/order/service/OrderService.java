package br.com.emmanuelneri.processor.order.service;

import br.com.emmanuelneri.processor.order.model.Order;
import br.com.emmanuelneri.processor.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order findCompleteByIdentifier(String identifier) {
        return orderRepository.findCompleteByIdentifier(identifier);
    }

    public boolean existsByIdentifier(String identifier) {
        return orderRepository.existsByIdentifier(identifier);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }
}
