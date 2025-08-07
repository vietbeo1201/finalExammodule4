package org.example.finalexammodule4.service;

import org.example.finalexammodule4.model.Customer;

import java.util.Optional;

public interface ICustomerService extends IGenerateService<Customer> {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
