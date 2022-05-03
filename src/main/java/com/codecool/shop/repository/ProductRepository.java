package com.codecool.shop.repository;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT t FROM ProductCategory t")
    List<ProductCategory> findAllByProductCategory();

    @Query("SELECT t FROM Supplier t")
    List<Supplier> findAllBySupplier();
}