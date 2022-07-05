package com.codecool.shop.repository;

import com.codecool.shop.model.Basket;
import com.codecool.shop.model.Customer;
import com.codecool.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

    List<Basket> findAllByCustomer(Object customer);
    Basket findByCustomerAndProduct(Customer customer, Product product);
    @Modifying
    void deleteByProduct_ProductIdAndCustomer_CustomerId(Integer productId, Integer customerId);
    @Modifying
    void deleteByCustomer_CustomerId(Integer customerId);

}
