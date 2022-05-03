package com.codecool.shop.repository;

import com.codecool.shop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT u FROM Customer u WHERE u.customerEmail = ?1")
    Customer findByEmail(String email);
}
