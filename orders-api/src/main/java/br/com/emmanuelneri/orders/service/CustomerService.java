package br.com.emmanuelneri.orders.service;

import br.com.emmanuelneri.orders.clients.Customers;
import br.com.emmanuelneri.orders.dto.CustomerDTO;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private Customers customers;

    public Map<Long, CustomerDTO> findAll() {
        try {
            return customers.findAll().stream()
                    .collect(Collectors.toMap(CustomerDTO::getId, identity()));
        } catch (FeignException fex) {
            log.error("Customer not avalible", fex);
            return new HashMap<>();
        }
    }

    public CustomerDTO findById(Long id) {
        try {
            return customers.findById(id);
        } catch (FeignException fex) {
            log.error("Customer not avalible", fex);
            return null;
        }
    }

}
