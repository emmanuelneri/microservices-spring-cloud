package br.com.emmanuelneri.receiver.controller;

import br.com.emmanuelneri.receiver.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/receiver/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @HystrixCommand(fallbackMethod = "defaultFallback")
    @RequestMapping(value = "/{origin}", method = RequestMethod.POST)
    public void receive(@PathVariable("origin") String origin, @RequestBody String order) {
        log.info("Order Received from {}", origin);
        orderService.receive(origin, order);
    }

    private void defaultFallback(String origin, String order) {
        log.error("System error - default fallback Method called - origin: " + origin);
    }

}
