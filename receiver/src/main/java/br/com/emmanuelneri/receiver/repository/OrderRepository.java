package br.com.emmanuelneri.receiver.repository;

import br.com.emmanuelneri.receiver.model.OrderFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderFile, String> {
}
