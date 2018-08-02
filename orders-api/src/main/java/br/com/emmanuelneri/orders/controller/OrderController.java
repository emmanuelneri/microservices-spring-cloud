package br.com.emmanuelneri.orders.controller;

import br.com.emmanuelneri.orders.dto.OrderDTO;
import br.com.emmanuelneri.orders.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(path = "/paged/{page}/{pageSize}", method = RequestMethod.GET)
    public Page<OrderDTO> findAllPaged(@PathVariable(name = "page") int page, @PathVariable(name = "pageSize") int pageSize) {
        log.info("findAll {}, {}", page, pageSize);
        return orderService.findAll(page, pageSize);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public OrderDTO findById(@PathVariable(name = "id") Long id) {
        log.info("findById {}", id);
        return orderService.findById(id);
    }

}
