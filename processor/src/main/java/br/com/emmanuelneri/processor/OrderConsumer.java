package br.com.emmanuelneri.processor;

import br.com.emmanuelneri.processor.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderConsumer {

    private static final String HEADER_PROPERTY_FILE_ID = "id";
    private Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private OrderService orderService;

    @JmsListener(destination = "${queue.process.name}")
    public void receive(@Headers Map<String, Object> headers,
                        @Payload String fileBody) {
        LOGGER.debug("Init process");
        orderService.process(fileBody, getFileId(headers));
        LOGGER.debug("Finish process");
    }

    public String getFileId(Map<String, Object> headers) {
        return (String) headers.get(HEADER_PROPERTY_FILE_ID);
    }

}
