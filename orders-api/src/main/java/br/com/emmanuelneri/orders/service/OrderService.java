package br.com.emmanuelneri.orders.service;

import br.com.emmanuelneri.orders.dto.CustomerDTO;
import br.com.emmanuelneri.orders.dto.OrderDTO;
import br.com.emmanuelneri.orders.mapper.OrderMapper;
import br.com.emmanuelneri.orders.model.Order;
import br.com.emmanuelneri.orders.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Map;

@Service
public class OrderService {

    private static final String ID_NOT_FOUND_ERROR_MSG = "id: %d not found";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    public OrderDTO findById(Long id) {
        final Order order = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format(ID_NOT_FOUND_ERROR_MSG, id)));
       final  CustomerDTO customerDTO = customerService.findById(order.getCustomer());
        return new OrderDTO(order, customerDTO);
    }

    public Page<OrderDTO> findAll(int page, int size) {
        final Page<Order> orderPaged = orderRepository.findAll(PageRequest.of(page, size));
        final Map<Long, CustomerDTO> customerById = customerService.findAll();
        return orderPaged.map(order -> OrderMapper.toDTO(order, customerById));
    }

}
