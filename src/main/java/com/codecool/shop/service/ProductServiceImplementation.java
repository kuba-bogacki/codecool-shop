package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listAll() {
        List<Product> allProducts = new ArrayList<>();
        productRepository.findAll().forEach(allProducts::add);
        return allProducts;
    }

    @Override
    public List<ProductCategory> listAllProductsCategory() {
        List<ProductCategory> allProductsCategory = new ArrayList<>();
        productRepository.findAllByProductCategory().forEach(allProductsCategory::add);
        return allProductsCategory;
    }

    @Override
    public List<Supplier> listAllSuppliers() {
        List<Supplier> allSupplier = new ArrayList<>();
        productRepository.findAllBySupplier().forEach(allSupplier::add);
        return allSupplier;
    }

}
