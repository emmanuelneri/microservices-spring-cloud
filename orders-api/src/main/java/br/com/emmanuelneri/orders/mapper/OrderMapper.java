package br.com.emmanuelneri.orders.mapper;

import br.com.emmanuelneri.orders.dto.CustomerDTO;
import br.com.emmanuelneri.orders.dto.OrderDTO;
import br.com.emmanuelneri.orders.model.Order;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderMapper {

    public static List<OrderDTO> toDTO(List<Order> orders, Map<Long, CustomerDTO> customerById) {
        return orders.stream()
                .map(order -> toDTO(order, customerById))
                .sorted(Comparator.comparing(OrderDTO::getDateTime))
                .collect(Collectors.toList());
    }

    public static OrderDTO toDTO(Order order, Map<Long, CustomerDTO> customerById) {
        return new OrderDTO(order, customerById.get(order.getCustomer()));
    }

}
