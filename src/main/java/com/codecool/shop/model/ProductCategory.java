package com.codecool.shop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_category")
public class ProductCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productCategoryId;
    private String productCategoryName;

    public ProductCategory(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public ProductCategory() {}

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productCategoryId=" + productCategoryId +
                ", productCategoryName='" + productCategoryName + '\'' +
                '}';
    }
}