package br.com.emmanuelneri.files.service;

import br.com.emmanuelneri.files.model.OrderFile;
import br.com.emmanuelneri.files.repository.OrderFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFileService {

    @Autowired
    private OrderFileRepository orderFileRepository;

    public Page<OrderFile> findAll(int page, int pageSize) {
        return orderFileRepository.findAllWithoutBody(page, pageSize);
    }

    public OrderFile findById(String id) {
        return orderFileRepository.findOne(id);
    }
}
