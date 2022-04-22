package com.codecool.shop.controller;

import com.codecool.shop.service.ProductCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductCategoryController {

    private ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @RequestMapping(value = "/find-by-category/{category}", method = RequestMethod.GET)
    public String findByCategory(Model model, @PathVariable String category) {
        model.addAttribute("products", productCategoryService.listByCategory(Integer.valueOf(category)));
        return "product/index";
    }
}
