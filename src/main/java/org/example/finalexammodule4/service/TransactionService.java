package org.example.finalexammodule4.service;

import org.example.finalexammodule4.model.Transaction;
import org.example.finalexammodule4.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private ITransactionRepository transactionRepository;

    @Override
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void remove(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Long findIdForNewCustomer(){
        Long lastId = transactionRepository.findLastId();
        if (lastId == null) {
            lastId = 0L;
        }
        return lastId + 1;
    }
}
