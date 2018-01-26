package br.com.emmanuelneri.processor.order.service;

import br.com.emmanuelneri.processor.exception.InvalidFileException;
import br.com.emmanuelneri.processor.order.model.Order;
import br.com.emmanuelneri.processor.util.Read;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrderProcessService {
    
    @Autowired
    private OrderService orderService;

    @Transactional
    public void process(String orderBody, String fileId) {
        final Order orderParsed = read(orderBody);
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

    private Order read(String fileBody) {
        try {
            return Read.createDeserializer().readValue(fileBody, Order.class);
        } catch (JsonParseException | JsonMappingException jex) {
            throw new InvalidFileException("invalid file", jex);
        } catch (Exception ex) {
           throw new IllegalArgumentException("unexpected error", ex);
        }
    }

}
