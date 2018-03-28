package br.com.emmanuelneri.orders.dto;

import br.com.emmanuelneri.orders.model.Order;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
public class OrderDTO {

    private Long id;
    private String identifier;
    private CustomerDTO customer;
    private LocalDateTime dateTime;
    private BigDecimal total;

    public OrderDTO(Order order, CustomerDTO customer) {
        this.id = order.getId();
        this.identifier = order.getIdentifier();
        this.dateTime = order.getDateTime();
        this.total = order.getTotal();
        this.customer = customer != null ? customer : new CustomerDTO(order.getCustomer());
    }
}
