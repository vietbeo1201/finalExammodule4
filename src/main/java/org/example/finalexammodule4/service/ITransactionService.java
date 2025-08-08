package org.example.finalexammodule4.service;

import org.example.finalexammodule4.model.Transaction;
import org.springframework.stereotype.Service;


public interface ITransactionService extends IGenerateService<Transaction> {
    Long findIdForNewCustomer();
}
