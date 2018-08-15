package br.com.emmanuelneri.processor.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Customer {

    @Id
    private Long id;
    private String cnpj;
    private String name;

    public Customer(Long id) {
        this.id = id;
    }
}
