package dev.emir.e_commerce.dto.request.product;

import dev.emir.e_commerce.entities.Category;
import dev.emir.e_commerce.entities.Supplier;
import jakarta.persistence.*;

public class ProductUpdateRequest {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int supplierId;
    private int categoryId;

    public ProductUpdateRequest(int id, String name, double price, int stock, int supplierId, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
    }

    public ProductUpdateRequest(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}

