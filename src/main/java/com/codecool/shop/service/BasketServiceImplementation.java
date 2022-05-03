package com.codecool.shop.service;

import com.codecool.shop.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImplementation implements BasketService {

    private BasketRepository basketRepository;

    @Autowired
    public BasketServiceImplementation(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }
}
