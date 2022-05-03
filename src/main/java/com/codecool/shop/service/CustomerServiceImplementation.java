package com.codecool.shop.service;

import com.codecool.shop.model.Customer;
import com.codecool.shop.model.Product;
import com.codecool.shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> listAllCustomers() {
        List<Customer> allCustomers = new ArrayList<>();
        customerRepository.findAll().forEach(allCustomers::add);
        return allCustomers;
    }

}
