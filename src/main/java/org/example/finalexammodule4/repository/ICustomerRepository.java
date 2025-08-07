package org.example.finalexammodule4.repository;

import org.example.finalexammodule4.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
