package br.com.emmanuelneri.receiver.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document(collection = "order")
@Getter
@ToString(of = {"id", "origin", "date"})
public class OrderFile {

    @Id
    private String id;
    private String origin;
    private String date;
    private String body;

    public OrderFile(String origin, String body) {
        this.origin = origin;
        this.body = body;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
