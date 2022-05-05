package com.codecool.shop.service;

import com.codecool.shop.model.Basket;
import com.codecool.shop.model.Customer;

import java.util.List;

public interface BasketService {
    List<Basket> listItemsInBasket(Customer customer);
    void addProductToBasket(Integer productId, Customer customer);
    void removeProductFromBasket(Integer productId, Customer customer);
}
