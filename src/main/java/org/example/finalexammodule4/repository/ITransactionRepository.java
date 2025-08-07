package org.example.finalexammodule4.repository;

import org.example.finalexammodule4.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
}
