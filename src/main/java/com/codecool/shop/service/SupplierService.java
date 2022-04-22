package com.codecool.shop.service;

import com.codecool.shop.model.Product;

import java.util.List;

public interface SupplierService {
    List<Product> listBySupplier(Integer id);
}
