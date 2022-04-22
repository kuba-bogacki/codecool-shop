package com.codecool.shop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplier_id;
    private String supplier_name;
    private String description;

    public Supplier(
            String supplier_name,
            String description) {
        this.supplier_name = supplier_name;
        this.description = description;
    }

    public Supplier() {}

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplier_id=" + supplier_id +
                ", supplier_name='" + supplier_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}