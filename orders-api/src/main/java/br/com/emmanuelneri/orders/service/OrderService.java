package br.com.emmanuelneri.orders.service;

import br.com.emmanuelneri.orders.model.Order;
import br.com.emmanuelneri.orders.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAllComplete();
    }

    public Order findById(Long id) {
        return orderRepository.findOneComplete(id);
    }

}
