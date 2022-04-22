package com.codecool.shop.controller;

import com.codecool.shop.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @RequestMapping(value = "/find-by-supplier/{supplier}", method = RequestMethod.GET)
    public String findBySupplier(Model model, @PathVariable String supplier) {
        model.addAttribute("products", supplierService.listBySupplier(Integer.valueOf(supplier)));
        return "product/index";
    }
}
