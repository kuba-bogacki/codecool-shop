package com.codecool.shop.repository;

import com.codecool.shop.model.Basket;
import com.codecool.shop.model.Customer;
import com.codecool.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

    List<Basket> findAllByCustomer(Object customer);
    Basket findByCustomerAndProduct(Customer customer, Product product);
}
