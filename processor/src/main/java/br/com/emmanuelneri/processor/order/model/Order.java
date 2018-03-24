package br.com.emmanuelneri.processor.order.model;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sales_order", uniqueConstraints = @UniqueConstraint(name = "sales_order_uk", columnNames = {"identifier"}))
@Getter
@ToString
public class Order {

    private static final String SEQUENCE_NAME = "sales_order_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    @NotEmpty
    @Size(max = 20)
    private String identifier;

    @NotNull
    private Long customerId;

    @NotNull
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @NotNull
    private BigDecimal total;

    public Order(){
    }

    public Order(String identifier, Long customerId, LocalDateTime dateTime, BigDecimal total) {
        this.identifier = identifier;
        this.customerId = customerId;
        this.dateTime = dateTime;
        this.total = total;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

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
