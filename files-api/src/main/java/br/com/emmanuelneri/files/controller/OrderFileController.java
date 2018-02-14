package br.com.emmanuelneri.files.controller;

import br.com.emmanuelneri.files.model.OrderFile;
import br.com.emmanuelneri.files.service.OrderFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders/files")
public class OrderFileController {

    @Autowired
    private OrderFileService orderFileService;

    @RequestMapping(method = RequestMethod.GET)
    public List<OrderFile> findAll() {
        return orderFileService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public OrderFile findById(@PathVariable(name = "id") String id) {
        return orderFileService.findById(id);
    }

}
