package org.example.finalexammodule4.controller;

import org.example.finalexammodule4.model.Customer;
import org.example.finalexammodule4.model.Transaction;
import org.example.finalexammodule4.service.ICustomerService;
import org.example.finalexammodule4.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("customer")
    public Iterable<Customer> getNameCustomer() {
        return customerService.findAll();
    }

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

    @GetMapping ("/detail/{id}")
    public ModelAndView renderDetailsForm(@PathVariable("id") Long transactionId, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("transaction/detail");
        Optional<Transaction> transaction = transactionService.findById(transactionId);
        if (transaction.isPresent()) {
            modelAndView.addObject("transaction", transaction.get());
            return modelAndView;
        }else{
            redirectAttributes.addFlashAttribute("errorMessage", "Transaction không tồn tại!");
            return new ModelAndView("redirect:/transaction/management");
        }
    }

    @Controller
    public class CustomErrorController implements ErrorController {
        @RequestMapping("/error")
        public String handleError() {
            return "error";
        }
    }


}
