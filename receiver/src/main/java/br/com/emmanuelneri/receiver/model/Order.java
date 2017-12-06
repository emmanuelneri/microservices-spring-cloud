package br.com.emmanuelneri.receiver.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document(collection = "order")
@Getter
public class Order {

    @Id
    private String id;

    private String origem;
    private String date;
    private String body;

    public Order(String origem, String body) {
        this.origem = origem;
        this.body = body;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
