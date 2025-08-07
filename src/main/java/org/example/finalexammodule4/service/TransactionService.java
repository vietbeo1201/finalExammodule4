package org.example.finalexammodule4.service;

import org.example.finalexammodule4.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {
    @Override
    public Iterable<Transaction> findAll() {
        return this.findAll();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return this.findById(id);
    }

    @Override
    public void save(Transaction transaction) {
        this.save(transaction);
    }

    @Override
    public void remove(Long id) {
        this.remove(id);
    }
}
