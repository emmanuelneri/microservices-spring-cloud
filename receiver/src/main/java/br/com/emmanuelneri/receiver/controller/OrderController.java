package br.com.emmanuelneri.receiver.controller;

import br.com.emmanuelneri.receiver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{origin}", method = RequestMethod.POST)
    public void receive(@PathVariable("origin") String origin, @RequestBody String order) {
        orderService.receive(origin, order);
    }

}
