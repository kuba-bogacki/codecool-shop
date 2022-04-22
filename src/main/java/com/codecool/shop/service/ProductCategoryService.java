package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<Product> listByCategory(Integer id);
}
