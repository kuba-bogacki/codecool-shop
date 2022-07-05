package com.codecool.shop.controller;

import com.codecool.shop.model.Customer;
import com.codecool.shop.service.CustomerService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginCustomer() {
        return "login-page";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "register-page";
    }

    @RequestMapping(value = "/process-register", method = RequestMethod.POST)
    public String registerProcess(Customer customer) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        customerService.saveNewCustomer(customer);
        return "successfully-registration";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("listCustomers", customerService.listAllCustomers());
        return "all-customers";
    }
}
