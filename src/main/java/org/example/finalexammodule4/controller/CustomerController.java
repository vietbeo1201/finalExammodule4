package org.example.finalexammodule4.controller;

import org.example.finalexammodule4.model.Customer;
import org.example.finalexammodule4.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
    @RequestMapping("/customer")
    public class CustomerController {
        @Autowired
        private ICustomerService customerService;

        @GetMapping("/management")
        public ModelAndView renderAllCustomers () {
            ModelAndView modelAndView = new ModelAndView();
            Iterable<Customer> customer = customerService.findAll();
            modelAndView.addObject("customers", customer);
            return modelAndView;
        }

        @GetMapping("/create")
        public ModelAndView renderCreateCustomer() {
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", new Customer());
            return modelAndView;
        }

        @PostMapping("/create")
        public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("message", "New customer created successfully");
            return modelAndView;
        }

//    @Controller
//    public class CustomErrorController implements ErrorController {
//        @RequestMapping("/error")
//        public String handleError() {
//            return "error";
//        }
//    }

}

