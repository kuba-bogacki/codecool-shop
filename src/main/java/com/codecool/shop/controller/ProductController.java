package com.codecool.shop.controller;

import com.codecool.shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findAllProducts(Model model) {
        model.addAttribute("products", productService.listAll());
        model.addAttribute("products_category", productService.listAllProductsCategory());
        model.addAttribute("suppliers", productService.listAllSuppliers());
        return "product/index";
    }

}