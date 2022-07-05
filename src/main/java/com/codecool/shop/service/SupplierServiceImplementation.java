package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImplementation implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImplementation(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Product> listBySupplier(Integer id) {
        List<Product> allProductsBySupplier = supplierRepository
                .findBySupplierId(id);
        return allProductsBySupplier;
    }
}
