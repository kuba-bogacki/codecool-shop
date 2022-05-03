package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImplementation implements ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImplementation(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<Product> listByCategory(Integer id) {
        List<Product> allProductsByCategory = productCategoryRepository
                .findByProductCategoryId(id);
        return allProductsByCategory;
    }
}
