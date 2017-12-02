package br.com.emmanuelneri.app.repository;

import br.com.emmanuelneri.app.model.File;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<File, String> {
}
