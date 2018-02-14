package br.com.emmanuelneri.files.service;

import br.com.emmanuelneri.files.model.OrderFile;
import br.com.emmanuelneri.files.repository.OrderFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFileService {

    @Autowired
    private OrderFileRepository orderFileRepository;

    public List<OrderFile> findAll() {
        return orderFileRepository.findAllWithoutBody();
    }

    public OrderFile findById(String id) {
        return orderFileRepository.findOne(id);
    }
}
