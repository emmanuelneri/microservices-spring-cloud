package br.com.emmanuelneri.processor.order.service;

import br.com.emmanuelneri.processor.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void process(String fileBody, String fileId) {
        //TODO
    }
}
