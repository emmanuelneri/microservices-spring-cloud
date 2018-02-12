package br.com.emmanuelneri.api.repository.impl;

import br.com.emmanuelneri.api.model.OrderFile;
import br.com.emmanuelneri.api.repository.OrderFileRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class OrderFileRepositoryImpl implements OrderFileRepositoryCustom {

    @Autowired
    private MongoOperations operations;

    @Override
    public List<OrderFile> findAllWithoutBody() {
       final Query query = new Query();
        query.fields().exclude("body");
        return operations.find(query, OrderFile.class);
    }
}
