package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.List;

public interface ProductService {
    List<Product> listAll();
    List<ProductCategory> listAllProductsCategory();
    List<Supplier> listAllSuppliers();
}
