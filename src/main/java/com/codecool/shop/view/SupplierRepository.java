package com.codecool.shop.view;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query("SELECT t FROM Product t WHERE t.supplier.supplier_id = ?1")
    List<Product> findBySupplierId(Integer id);
}
