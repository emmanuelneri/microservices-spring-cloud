package br.com.emmanuelneri.app.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document(collection = "file")
@Getter
public class File {

    @Id
    private String id;
    private String date;
    private String fileName;
    private String body;

    public File(String fileName, String body) {
        this.fileName = fileName;
        this.body = body;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
