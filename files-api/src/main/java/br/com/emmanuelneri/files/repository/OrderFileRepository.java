package br.com.emmanuelneri.files.repository;

import br.com.emmanuelneri.files.model.OrderFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderFileRepository extends MongoRepository<OrderFile, String>, OrderFileRepositoryCustom {


}
