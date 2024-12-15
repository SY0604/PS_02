package com.example.inventory.dto;

public class InventoryDTO {

    private Long id;
    private int stock;

    // Constructors
    public InventoryDTO(Long id, int stock) {
        this.id = id;
        this.stock = stock;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
