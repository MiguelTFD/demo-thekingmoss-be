package com.thekingmoss.service;

import com.thekingmoss.dto.category.CategoryRequestDto;
import com.thekingmoss.dto.category.CategoryResponseDto;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto getCategoryById(Long id);
    CategoryResponseDto createCategory(CategoryRequestDto requestDto);
    CategoryResponseDto updateCategory(Long id, CategoryRequestDto requestDto);
    void deleteCategory(Long id);
}
