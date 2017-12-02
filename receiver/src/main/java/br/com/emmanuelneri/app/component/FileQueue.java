package br.com.emmanuelneri.app.component;

import br.com.emmanuelneri.app.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.HashMap;
import java.util.Map;

@Component
public class FileQueue {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void send(File file) {
        final Map<String, Object> headers = createHeader(file);
        this.jmsMessagingTemplate.convertAndSend(this.queue, file.getBody(), headers);
    }

    private Map<String, Object> createHeader(File file) {
        final Map<String, Object> headers = new HashMap<>();
        headers.put("id", file.getId());
        return headers;
    }
}
