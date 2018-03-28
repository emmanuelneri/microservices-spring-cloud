package br.com.emmanuelneri.orders.service;

import br.com.emmanuelneri.orders.dto.CustomerDTO;
import br.com.emmanuelneri.orders.dto.OrderDTO;
import br.com.emmanuelneri.orders.model.Order;
import br.com.emmanuelneri.orders.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    public List<OrderDTO> findAll() {
        final List<Order> orders = orderRepository.findAll();
        final Map<Long, CustomerDTO> customerById = customerService.findAll();

        return orders.stream()
                .map(order -> new OrderDTO(order, customerById.get(order.getCustomer())))
                .sorted(Comparator.comparing(OrderDTO::getDateTime))
                .collect(Collectors.toList());
    }

    public OrderDTO findById(Long id) {
        final Order order = orderRepository.findOne(id);
       final  CustomerDTO customerDTO = customerService.findById(order.getCustomer());
        return new OrderDTO(order, customerDTO);
    }

}
