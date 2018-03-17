package br.com.emmanuelneri.customers.model;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@ToString
public class Customer implements Serializable {

    @Id
    @Size(min = 14, max = 14, message = "Invalid CNPJ: must be between {min} and {max} characters")
    private String cnpj;

    @Size(max = 200, message = "Invalid Name: max characters exceeded ({max})")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cnpj, customer.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }
}
