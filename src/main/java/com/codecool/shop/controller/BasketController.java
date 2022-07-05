package com.codecool.shop.controller;

import com.codecool.shop.model.Customer;
import com.codecool.shop.service.BasketService;
import com.codecool.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasketController {

    private final BasketService basketService;
    private final CustomerService customerService;

    @Autowired
    public BasketController(BasketService basketService, CustomerService customerService) {
        this.basketService = basketService;
        this.customerService = customerService;
    }

    @RequestMapping(value = "/show-basket", method = RequestMethod.GET)
    public String showProductsInBasket(Model model, Authentication authentication) {
        Customer customer = customerService.getCurrentlyLoggedInCustomer(authentication);
        model.addAttribute("itemsList", basketService.listItemsInBasket(customer));
        model.addAttribute("pageTitle", "shoppingBasket");
        return "product/basket";
    }

    @RequestMapping(value = "/show-basket/add/{productId}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public String addProductToBasket(@PathVariable Integer productId, Authentication authentication) {
        String modalInformation = "";
        if (authentication == null) {
            modalInformation = "You need to login first";
        } else {
            Customer customer = customerService.getCurrentlyLoggedInCustomer(authentication);
            basketService.addProductToBasket(productId, customer);
            modalInformation = "Product successfully added to your basket";
        }
        return modalInformation;
    }

    @RequestMapping(value = "/show-basket/delete/{productId}", produces = "application/json", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteProductFromBasket(@PathVariable Integer productId, Authentication authentication) {
        String modalInformation = "";
        Customer customer = customerService.getCurrentlyLoggedInCustomer(authentication);
        basketService.removeProductFromBasket(productId, customer);
        modalInformation = "Product successfully removed from your basket";
        return modalInformation;
    }
}
