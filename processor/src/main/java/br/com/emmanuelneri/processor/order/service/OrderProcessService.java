package br.com.emmanuelneri.processor.order.service;

import br.com.emmanuelneri.processor.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderProcessService {
    
    @Autowired
    private OrderService orderService;

    @Transactional
    public void process(Order orderParsed) {
        final boolean existsOrder = orderService.existsByIdentifier(orderParsed.getIdentifier());

        if(existsOrder) {
            updateOrder(orderParsed);
        } else {
            createOrder(orderParsed);
        }
    }

    private void createOrder(Order order) {
        orderService.save(order);
    }

    private void updateOrder(Order orderParsed) {
        final Order existingOrder = orderService.findCompleteByIdentifier(orderParsed.getIdentifier());

        existingOrder.setDateTime(orderParsed.getDateTime());
        existingOrder.setTotal(orderParsed.getTotal());

        orderService.save(existingOrder);
    }

}
