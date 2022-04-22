package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.sun.xml.bind.v2.model.core.ID;

import java.util.List;

public interface ProductService {
    List<Product> listAll();
    List<ProductCategory> listAllProductsCategory();
    List<Supplier> listAllSuppliers();
}
