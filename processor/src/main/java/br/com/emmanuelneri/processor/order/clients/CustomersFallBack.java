package br.com.emmanuelneri.processor.order.clients;

import br.com.emmanuelneri.processor.order.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomersFallBack implements Customers {

    private static final Long ERROR_CLIENT_ID = 99L;

    @Override
    public Customer findByCnpj(String cnpj) {
        log.error("Customer App unavailable");
       return new Customer(ERROR_CLIENT_ID);
    }
}
