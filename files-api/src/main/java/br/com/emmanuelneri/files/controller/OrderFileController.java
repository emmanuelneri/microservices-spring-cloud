package br.com.emmanuelneri.files.controller;

import br.com.emmanuelneri.files.model.OrderFile;
import br.com.emmanuelneri.files.service.OrderFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/files/orders")
@Slf4j
public class OrderFileController {

    @Autowired
    private OrderFileService orderFileService;

    @RequestMapping(path = "/paged/{page}/{pageSize}", method = RequestMethod.GET)
    public Page<OrderFile> findAll(@PathVariable(name = "page") int page, @PathVariable(name = "pageSize") int pageSize) {
        log.info("findAll {}, {}", page, pageSize);
        return orderFileService.findAll(page, pageSize);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public OrderFile findById(@PathVariable(name = "id") String id) {
        log.info("findById {}", id);
        return orderFileService.findById(id);
    }

}
