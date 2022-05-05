package com.codecool.shop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "basket")
public class Basket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private int quantity;

    public Basket(Product product, Customer customer, int quantity) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public Basket() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Transient
    public float getSubTotal() {
        return (float) (this.product.getDefaultPrice() * this.quantity);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", product=" + product +
                ", customer=" + customer +
                ", quantity=" + quantity +
                '}';
    }
}
