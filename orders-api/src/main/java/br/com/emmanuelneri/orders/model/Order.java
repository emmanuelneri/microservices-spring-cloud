package br.com.emmanuelneri.orders.model;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sales_order")
@Getter
@ToString
public class Order {

    @Id
    private Long id;

    private String identifier;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    private BigDecimal total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(identifier, order.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
