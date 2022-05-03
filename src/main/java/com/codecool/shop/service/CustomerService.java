package com.codecool.shop.service;

import com.codecool.shop.model.Customer;

import java.util.List;

public interface CustomerService {
    void saveNewCustomer(Customer customer);
    List<Customer> listAllCustomers();
}
