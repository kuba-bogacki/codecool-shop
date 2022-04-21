package com.codecool.shop.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1234567L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //dodawanie kolejnych id na poziomie tabeli
    private int productId;
    private String productName;
    private double defaultPrice;
    private String currency;
    @Type(type = "text")
    private String description;
    @ManyToMany
    private List<Supplier> supplier;
    @ManyToOne
    private ProductCategory productCategory;

    public Product(int productId, String productName,
                   double defaultPrice, String currency,
                   String description, List<Supplier> supplier,
                   ProductCategory productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.defaultPrice = defaultPrice;
        this.currency = currency;
        this.description = description;
        this.supplier = supplier;
        this.productCategory = productCategory;
    }

    public Product() {}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Supplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(List<Supplier> supplier) {
        this.supplier = supplier;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", defaultPrice='" + defaultPrice + '\'' +
                ", currency='" + currency + '\'' +
                ", description='" + description + '\'' +
                ", supplier=" + supplier +
                ", productCategory=" + productCategory +
                '}';
    }
}
