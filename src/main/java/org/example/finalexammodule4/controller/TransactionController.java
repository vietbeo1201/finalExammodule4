package org.example.finalexammodule4.controller;

import org.example.finalexammodule4.model.Transaction;
import org.example.finalexammodule4.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;

    @GetMapping("/management")
    public ModelAndView renderAllTransactions() {
        Iterable<Transaction> transactions = transactionService.findAll();
        ModelAndView mav = new ModelAndView("/transaction/list");
        mav.addObject("transactions", transactions);
        return mav;
    }
}
