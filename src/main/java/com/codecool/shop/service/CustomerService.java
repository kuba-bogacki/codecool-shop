package com.codecool.shop.service;

import com.codecool.shop.model.Customer;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface CustomerService {
    void saveNewCustomer(Customer customer);
    List<Customer> listAllCustomers();
    Customer getCurrentlyLoggedInCustomer(Authentication authentication);
}
