package com.ajinkyacodes.expense_tracker.service.impl;

import com.ajinkyacodes.expense_tracker.dto.CategoryDto;
import com.ajinkyacodes.expense_tracker.entity.Category;
import com.ajinkyacodes.expense_tracker.mapper.CategoryMapper;
import com.ajinkyacodes.expense_tracker.repository.CategoryRepository;
import com.ajinkyacodes.expense_tracker.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category) -> CategoryMapper.mapToCategoryDto(category)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
        // get category entity from the database bt category id
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found with id: "+ categoryId));

        // Update category entity object and save to database table
        category.setName(categoryDto.name());

        Category updateCategory = categoryRepository.save(category); // performs update operation
        return CategoryMapper.mapToCategoryDto(updateCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        // Check if a category with given id exists in a database
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found with id: "+ categoryId));

        categoryRepository.delete(category);
    }
}
