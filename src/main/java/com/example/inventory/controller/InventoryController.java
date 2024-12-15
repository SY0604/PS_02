package com.example.inventory.controller;

import com.example.inventory.entity.Inventory;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // Endpoint to add stock to inventory
    @PutMapping("/{inventoryId}/add")
    @ResponseStatus(HttpStatus.OK)
    public Inventory increaseStock(@PathVariable Long inventoryId, @RequestParam int quantity) {
        return inventoryService.updateStock(inventoryId, quantity);
    }

    // Endpoint to deduct stock from inventory
    @PutMapping("/{inventoryId}/deduct")
    @ResponseStatus(HttpStatus.OK)
    public Inventory decreaseStock(@PathVariable Long inventoryId, @RequestParam int quantity) {
        return inventoryService.updateStock(inventoryId, -quantity);
    }
}
