package br.com.emmanuelneri.processor.order.components;

import br.com.emmanuelneri.processor.order.model.Order;
import br.com.emmanuelneri.processor.order.service.OrderService;
import br.com.emmanuelneri.processor.order.to.OrderTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderProcess {
    
    @Autowired
    private OrderService orderService;

    @Transactional
    public void process(OrderTO orderTO) {
        final boolean existsOrder = orderService.existsByIdentifier(orderTO.getIdentifier());

        if(existsOrder) {
            updateOrder(orderTO);
        } else {
            createOrder(orderTO);
        }
    }

    private void createOrder(OrderTO orderTO) {
        orderService.save(orderTO.toEntity());
    }

    private void updateOrder(OrderTO orderTO) {
        final Order existingOrder = orderService.findCompleteByIdentifier(orderTO.getIdentifier());

        existingOrder.setDateTime(orderTO.getDateTime());
        existingOrder.setTotal(orderTO.getTotal());

        orderService.save(existingOrder);
    }

}
