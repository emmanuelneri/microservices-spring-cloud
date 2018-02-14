package br.com.emmanuelneri.files.repository;

import br.com.emmanuelneri.files.model.OrderFile;

import java.util.List;

public interface OrderFileRepositoryCustom {

    List<OrderFile> findAllWithoutBody();

}
