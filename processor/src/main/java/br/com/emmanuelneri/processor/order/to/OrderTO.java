package br.com.emmanuelneri.processor.order.to;

import br.com.emmanuelneri.processor.order.model.Order;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderTO {

    private String identifier;

    private CustomerTO customer;

    // TODO precisa?
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateTime;

    private BigDecimal total;

    public Order toEntity() {
        return new Order(this.identifier, this.customer.getId(), this.dateTime, this.total);
    }

}
