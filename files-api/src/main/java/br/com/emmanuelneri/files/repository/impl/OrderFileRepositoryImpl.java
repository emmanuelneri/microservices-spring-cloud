package br.com.emmanuelneri.files.repository.impl;

import br.com.emmanuelneri.files.model.OrderFile;
import br.com.emmanuelneri.files.repository.OrderFileRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;

import java.util.List;

public class OrderFileRepositoryImpl implements OrderFileRepositoryCustom {

    @Autowired
    private MongoOperations operations;

    @Override
    public Page<OrderFile> findAllWithoutBody(int page, int pageSize) {
        final Pageable pageable = new PageRequest(page, pageSize);

        final Query query = new Query();
        query.fields().exclude("body");
        query.with(pageable);

        final List<OrderFile> orderFiles = find(query);

        return PageableExecutionUtils.getPage(orderFiles, pageable, () -> count(query));
    }

    private long count(Query query) {
        return operations.count(query, OrderFile.class);
    }

    private List<OrderFile> find(Query query) {
        return operations.find(query, OrderFile.class);
    }
}
