package com.codecool.shop.repository;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    @Query("SELECT t FROM Product t WHERE t.productCategory.productCategoryId = ?1")
    List<Product> findByProductCategoryId(Integer id);

}
