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
        return "product/index";
    }

    @RequestMapping(value = "/find-by-category/{category}", method = RequestMethod.GET)
    public String findByCategory(Model model, @PathVariable String category) {
        model.addAttribute("products", productService.listAll());
        return "product/index";
    }

    @RequestMapping(value = "/find-by-supplier/{supplier}", method = RequestMethod.GET)
    public String findBySupplier(Model model, @PathVariable String supplier) {
        model.addAttribute("products", productService.listAll());
        return "product/index";
    }
}