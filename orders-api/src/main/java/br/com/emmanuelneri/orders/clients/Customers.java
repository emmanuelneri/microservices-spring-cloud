package br.com.emmanuelneri.orders.clients;

import br.com.emmanuelneri.orders.dto.CustomerDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "customers")
public interface Customers {

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    CustomerDTO findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    List<CustomerDTO> findAll();

}
