package br.com.emmanuelneri.customers.controller;

import br.com.emmanuelneri.customers.model.Customer;
import br.com.emmanuelneri.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @RequestMapping(value = "/document/{cnpj}", method = RequestMethod.GET)
    public ResponseEntity<Customer> findByCnpj(@PathVariable(value = "cnpj") String cnpj) {
        final Customer customer = customerService.findByCnpj(cnpj);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> findById(@PathVariable(value = "id") Long id) {
        final Customer customer = customerService.findById(id);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void receive(@RequestBody Customer customer) {
        customerService.save(customer);
    }

}
