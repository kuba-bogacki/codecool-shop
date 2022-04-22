package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.view.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImplementation implements SupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImplementation(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Product> listBySupplier(Integer id) {
        List<Product> allProductsBySupplier = supplierRepository
                .findBySupplierId(id)
                .stream()
                .collect(Collectors.toList());
        return allProductsBySupplier;
    }
}
