package br.com.emmanuelneri.customers.respository;

import br.com.emmanuelneri.customers.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}

