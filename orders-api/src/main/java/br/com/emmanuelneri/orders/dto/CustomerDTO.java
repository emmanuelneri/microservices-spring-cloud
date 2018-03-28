package br.com.emmanuelneri.orders.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CustomerDTO {

    private Long id;
    private String cnpj;
    private String name;

    public CustomerDTO() {
    }

    public CustomerDTO(Long customerId) {
        this.id = customerId;
    }
}
