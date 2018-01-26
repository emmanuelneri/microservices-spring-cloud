package br.com.emmanuelneri.processor.order.model;

import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter
public class Customer {

    @Id
    @NotEmpty
    @Size(max = 14)
    private String cnpj;

    @NotEmpty
    @Size(max = 200)
    private String name;

}
