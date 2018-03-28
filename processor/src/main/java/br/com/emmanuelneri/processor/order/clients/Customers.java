package br.com.emmanuelneri.processor.order.clients;

import br.com.emmanuelneri.processor.order.model.Customer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "customers")
public interface Customers {

    @RequestMapping(value = "/customers/document/{cnpj}", method = RequestMethod.GET)
    Customer findByCnpj(@PathVariable("cnpj") String cnpj);

}
