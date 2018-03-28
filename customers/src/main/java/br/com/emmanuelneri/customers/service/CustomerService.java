package br.com.emmanuelneri.customers.service;

import br.com.emmanuelneri.customers.model.Customer;
import br.com.emmanuelneri.customers.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private static final String CACHE = "customers";

    @Autowired
    private CustomerRepository customerRepository;

    @Cacheable(cacheNames = CACHE, key="#root.method.name")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Cacheable(cacheNames = CACHE, key="#root.method.name + '(' + #cnpj + ')'")
    public Customer findByCnpj(String cnpj) {
        return customerRepository.findByCnpj(cnpj);
    }

    @Cacheable(cacheNames = CACHE, key="#root.method.name + '(' + #id + ')'")
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    @CacheEvict(cacheNames = CACHE, allEntries = true)
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}

