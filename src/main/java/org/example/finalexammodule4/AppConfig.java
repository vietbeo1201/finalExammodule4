package org.example.finalexammodule4;

import org.example.finalexammodule4.formatter.CustomerNameFormatter;
import org.example.finalexammodule4.service.CustomerService;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    private final CustomerService customerService;

    public AppConfig(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new CustomerNameFormatter(customerService));
    }
}
