package com.thekingmoss.service;

import com.thekingmoss.dto.category.CategoryRequestDto;
import com.thekingmoss.dto.category.CategoryResponseDto;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponseDto> getAll();
    CategoryResponseDto getById(Long id);
    CategoryResponseDto create(CategoryRequestDto requestDto);
    void delete(Long id);
}
