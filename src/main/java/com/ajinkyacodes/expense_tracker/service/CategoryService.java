package com.ajinkyacodes.expense_tracker.service;

import com.ajinkyacodes.expense_tracker.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(Long categoryId);
    List<CategoryDto> getAllCategories();
}
