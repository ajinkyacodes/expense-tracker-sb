package com.ajinkyacodes.expense_tracker.controller;

import com.ajinkyacodes.expense_tracker.dto.CategoryDto;
import com.ajinkyacodes.expense_tracker.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories") // Define the base URL
public class CategoryController {
    private CategoryService categoryService;

    // Build Create Category REST API
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    // Build Get Category By Id REST API
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId) {
        CategoryDto category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }
}
