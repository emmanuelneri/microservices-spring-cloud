package br.com.emmanuelneri.orders.service;

import br.com.emmanuelneri.orders.dto.CustomerDTO;
import br.com.emmanuelneri.orders.dto.OrderDTO;
import br.com.emmanuelneri.orders.mapper.OrderMapper;
import br.com.emmanuelneri.orders.model.Order;
import br.com.emmanuelneri.orders.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public OrderDTO findById(Long id) {
        final Order order = orderRepository.findOne(id);
       final  CustomerDTO customerDTO = customerService.findById(order.getCustomer());
        return new OrderDTO(order, customerDTO);
    }

    public Page<OrderDTO> findAll(int page, int size) {
        final Page<Order> orderPaged = orderRepository.findAll(new PageRequest(page, size));
        final Map<Long, CustomerDTO> customerById = customerService.findAll();
        return orderPaged.map(order -> OrderMapper.toDTO(order, customerById));
    }

}
