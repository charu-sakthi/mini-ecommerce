
package com.example.miniecommerce.dto;

public class ProductResponseDTO {

    private String name;
    private double price;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(String name, double price) {
        this.name = name;
        this.price = price;
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
}
