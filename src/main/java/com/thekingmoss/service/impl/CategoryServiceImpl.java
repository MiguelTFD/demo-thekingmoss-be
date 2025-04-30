package com.thekingmoss.service.impl;

import com.thekingmoss.dto.category.CategoryRequestDto;
import com.thekingmoss.dto.category.CategoryResponseDto;
import com.thekingmoss.entity.Category;
import com.thekingmoss.mapper.category.CategoryMapper;
import com.thekingmoss.repository.ICategoryRepository;
import com.thekingmoss.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository repository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseDto> getAll() {
        return repository.findAll().stream()
                .map(categoryMapper::toDo)
                .toList();
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        return repository.findById(id)
                .map(categoryMapper::toDo)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public CategoryResponseDto create(CategoryRequestDto requestDto) {
        Category category = categoryMapper.toEntity(requestDto);
        return categoryMapper.toDo(repository.save(category));
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Category not found with ID :" + id);
        }
        repository.deleteById(id);
    }
}
