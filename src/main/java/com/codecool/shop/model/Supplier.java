package com.codecool.shop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;
    private String supplierName;
    private String description;

    public Supplier(String supplierName, String description) {
        this.supplierName = supplierName;
        this.description = description;
    }

    public Supplier() {}

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}