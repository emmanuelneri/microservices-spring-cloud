package br.com.emmanuelneri.files.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
@Getter
public class OrderFile {

    @Id
    private String id;

    private String origin;
    private String date;
    private String body;
}
