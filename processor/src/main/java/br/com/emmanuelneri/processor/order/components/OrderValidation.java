package br.com.emmanuelneri.processor.order.components;

import br.com.emmanuelneri.processor.exception.BusinessException;
import br.com.emmanuelneri.processor.order.clients.Customers;
import br.com.emmanuelneri.processor.order.model.Customer;
import br.com.emmanuelneri.processor.order.to.CustomerTO;
import br.com.emmanuelneri.processor.order.to.OrderTO;
import com.google.common.base.Strings;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.core.GenericSelector;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderValidation implements GenericSelector<OrderTO> {

    @Autowired
    private Customers customers;

    @Override
    public boolean accept(OrderTO order) {
        final boolean valid = mandatoryFieldsValidations(order);
        integrityValidations(order);
        return valid;
    }

    private boolean mandatoryFieldsValidations(OrderTO order) {
        if(Strings.isNullOrEmpty(order.getIdentifier())) {
            log.error(order + " - Identifier required");
            return false;
        }

        if(order.getCustomer() == null || Strings.isNullOrEmpty(order.getCustomer().getCnpj())) {
            log.error(order + " - Customer required");
            return false;
        }

        if(order.getDateTime() == null) {
            log.error(order + " - DateTime required");
            return false;
        }

        if(order.getTotal() == null) {
            log.error(order + " - Total required");
            return false;
        }

        return true;
    }

    private void integrityValidations(OrderTO order) {
        validateAndSetCustomer(order);
    }

    private void validateAndSetCustomer(OrderTO order) {
        try {
            String cnpj = order.getCustomer().getCnpj();
            final Customer customer = customers.findByCnpj(cnpj);
            order.setCustomer(new CustomerTO(customer.getId()));
        } catch (FeignException fex) {
            if(fex.status() == HttpStatus.NOT_FOUND.value()) {
                log.error("Customer not found: " + order.getCustomer());
                throw new BusinessException(order + " - Invalid customer");
            } else {
                log.error("Customer Service error", fex);
                throw new RuntimeException("Customer Service error");
            }
        }
    }
}
