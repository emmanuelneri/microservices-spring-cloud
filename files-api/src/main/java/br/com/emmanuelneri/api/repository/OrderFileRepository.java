package br.com.emmanuelneri.api.repository;

import br.com.emmanuelneri.api.model.OrderFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderFileRepository extends MongoRepository<OrderFile, String>, OrderFileRepositoryCustom {


}
