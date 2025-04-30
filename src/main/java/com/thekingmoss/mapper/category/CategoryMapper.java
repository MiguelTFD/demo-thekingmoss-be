package com.thekingmoss.mapper.category;

import com.thekingmoss.dto.category.CategoryRequestDto;
import com.thekingmoss.dto.category.CategoryResponseDto;
import com.thekingmoss.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryResponseDto toDo(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public Category toEntity(CategoryRequestDto requestDto) {
        return Category.builder()
                .name(requestDto.getName())
                .build();
    }

    public Category toEntityCategory(CategoryResponseDto responseDto) {
        return Category.builder()
                .id(responseDto.getId())
                .name(responseDto.getName())
                .build();
    }
}
