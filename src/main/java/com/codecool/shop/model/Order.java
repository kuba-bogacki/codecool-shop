package com.codecool.shop.model;

import lombok.Data;

@Data
public class Order {

    private double orderPrice;
    private String orderCurrency;
    private String orderMethod;
    private String orderIntent;
    private String orderDescription;

    public Order(double orderPrice, String orderCurrency,
                 String orderMethod, String orderIntent, String orderDescription) {
        this.orderPrice = orderPrice;
        this.orderCurrency = orderCurrency;
        this.orderMethod = orderMethod;
        this.orderIntent = orderIntent;
        this.orderDescription = orderDescription;
    }

    public Order() {}

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public String getOrderMethod() {
        return orderMethod;
    }

    public void setOrderMethod(String orderMethod) {
        this.orderMethod = orderMethod;
    }

    public String getOrderIntent() {
        return orderIntent;
    }

    public void setOrderIntent(String orderIntent) {
        this.orderIntent = orderIntent;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderPrice=" + orderPrice +
                ", orderCurrency='" + orderCurrency + '\'' +
                ", orderMethod='" + orderMethod + '\'' +
                ", orderIntent='" + orderIntent + '\'' +
                ", orderDescription='" + orderDescription + '\'' +
                '}';
    }
}
