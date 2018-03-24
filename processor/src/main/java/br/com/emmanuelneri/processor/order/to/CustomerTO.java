package br.com.emmanuelneri.processor.order.to;

import lombok.Data;

@Data
public class CustomerTO {

    private Long id;
    private String cnpj;
    private String name;

    public CustomerTO() {
    }

    public CustomerTO(Long id) {
        this.id = id;
    }
}
