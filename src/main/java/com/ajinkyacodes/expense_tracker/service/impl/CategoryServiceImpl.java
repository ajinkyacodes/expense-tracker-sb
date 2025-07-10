package com.ajinkyacodes.expense_tracker.service.impl;

import com.ajinkyacodes.expense_tracker.dto.CategoryDto;
import com.ajinkyacodes.expense_tracker.entity.Category;
import com.ajinkyacodes.expense_tracker.mapper.CategoryMapper;
import com.ajinkyacodes.expense_tracker.repository.CategoryRepository;
import com.ajinkyacodes.expense_tracker.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        // Convert CategoryDto to Category entity
        Category category = CategoryMapper.mapToCategory(categoryDto);

        // Save category object into database table - categories
        Category savedCategory = categoryRepository.save(category);

        // convert savedCategory to CategoryDto
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found with id: "+categoryId));
        return CategoryMapper.mapToCategoryDto(category);
    }
}
