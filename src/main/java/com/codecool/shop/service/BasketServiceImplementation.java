package com.codecool.shop.service;

import com.codecool.shop.model.Basket;
import com.codecool.shop.model.Customer;
import com.codecool.shop.model.Product;
import com.codecool.shop.repository.BasketRepository;
import com.codecool.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BasketServiceImplementation implements BasketService {

    private final BasketRepository basketRepository;
    private final ProductRepository productRepository;

    @Autowired
    public BasketServiceImplementation(BasketRepository basketRepository, ProductRepository productRepository) {
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Basket> listItemsInBasket(Customer customer) {
        List<Basket> itemsList = basketRepository.findAllByCustomer(customer);
        return itemsList;
    }

    @Override
    public void addProductToBasket(Integer productId, Customer customer) {
        int quantity = 1;
        Product product = productRepository.findById(productId).get();
        Basket basket = basketRepository.findByCustomerAndProduct(customer, product);
        if (basket != null) {
            int addedQuantity = basket.getQuantity() + quantity;
            basket.setQuantity(addedQuantity);
        } else {
            basket = new Basket();
            basket.setProduct(product);
            basket.setQuantity(quantity);
            basket.setCustomer(customer);
        }
        basketRepository.save(basket);
    }

    @Override
    @Transactional
    public void removeProductFromBasket(Integer productId, Customer customer) {
        basketRepository.deleteByProduct_ProductIdAndCustomer_CustomerId(productId, customer.getCustomerId());
    }

    @Override
    @Transactional
    public void removeAllProductsFromBasket(Customer customer) {
        basketRepository.deleteByCustomer_CustomerId(customer.getCustomerId());
    }
}
