package org.example.finalexammodule4.formatter;

import org.example.finalexammodule4.model.Customer;
import org.example.finalexammodule4.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class CustomerNameFormatter implements Formatter<Customer> {

    private final ICustomerService customerService;

    @Autowired
    public CustomerNameFormatter(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer parse(String text, Locale locale) {
        Optional<Customer> customerOptional = customerService.findById(Long.parseLong(text));
        return customerOptional.orElse(null);
    }

    @Override
    public String print(Customer customer, Locale locale) {
        return "[" + customer.getCusId() + ", " +customer.getCusName() + "]";
    }
}
