package org.example.finalexammodule4.controller;

import org.example.finalexammodule4.model.Customer;
import org.example.finalexammodule4.model.Transaction;
import org.example.finalexammodule4.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;

    @GetMapping("/management")
    public ModelAndView renderAllTransactions() {
        ModelAndView modelAndView = new ModelAndView("/transaction/list");
        Iterable<Transaction> transactions = transactionService.findAll();
        modelAndView.addObject("transactions", transactions);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView renderCreateTransactionForm( Model model) {
        ModelAndView modelAndView = new ModelAndView("/transaction/create");
        modelAndView.addObject("transaction", new Transaction());
        Long nextId = transactionService.findIdForNewCustomer();
        model.addAttribute("nextId", nextId );
        return modelAndView;
    }

    @PostMapping("/create")
    public String processCreateTransactionForm(@ModelAttribute("transaction") Transaction transaction, RedirectAttributes redirectAttributes) {
        transactionService.save(transaction);
        redirectAttributes.addFlashAttribute("message", "create new province successfully");
        return "redirect:/transaction/create";

    }
}
