package br.com.emmanuelneri.api.repository;

import br.com.emmanuelneri.api.model.OrderFile;

import java.util.List;

public interface OrderFileRepositoryCustom {

    List<OrderFile> findAllWithoutBody();

}
