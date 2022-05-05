package com.codecool.shop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false, unique = true)
    private String customerEmail;
    @Column(nullable = false)
    private String password;

    public Customer(String customerName, String customerEmail, String password) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.password = password;
    }

    public Customer() {}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
