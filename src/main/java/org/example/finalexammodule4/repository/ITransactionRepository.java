package org.example.finalexammodule4.repository;

import org.example.finalexammodule4.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT MAX(c.transId) FROM Transaction c")
    Long findLastId();
}
