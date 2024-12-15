package com.example.inventory.controller;

import com.example.inventory.entity.Category;
import com.example.inventory.exception.ResourceNotFoundException;
import com.example.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Retrieve all categories
    @GetMapping
    public List<Category> fetchAllCategories() {
        return categoryService.getAllCategories();
    }

    // Retrieve a category by its ID
    @GetMapping("/{id}")
    public Category fetchCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with ID " + id + " not found"));
    }

    // Create a new category
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category addNewCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    // Delete a category by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
