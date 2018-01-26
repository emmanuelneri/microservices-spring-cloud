package br.com.emmanuelneri.processor;

import br.com.emmanuelneri.processor.order.service.OrderProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class OrderConsumer {

    private static final String HEADER_PROPERTY_FILE_ID = "id";

    @Autowired
    private OrderProcessService orderProcessService;

    @RabbitListener(queues = {"${queue.order.name}"})
    public void receive(@Headers Map<String, Object> headers, @Payload String fileBody) {
        log.info("Init process");
        orderProcessService.process(fileBody, getFileId(headers));
        log.info("Finish process");
    }

    private String getFileId(Map<String, Object> headers) {
        return String.valueOf(headers.get(HEADER_PROPERTY_FILE_ID));
    }

}
