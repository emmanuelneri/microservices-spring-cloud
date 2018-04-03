package br.com.emmanuelneri.files.repository;

import br.com.emmanuelneri.files.model.OrderFile;
import org.springframework.data.domain.Page;

public interface OrderFileRepositoryCustom {

    Page<OrderFile> findAllWithoutBody(int page, int pageSize);

}
