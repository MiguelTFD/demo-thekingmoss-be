package com.thekingmoss.service.impl;

import com.thekingmoss.dto.category.CategoryResponseDto;
import com.thekingmoss.dto.product.ProductRequestDto;
import com.thekingmoss.dto.product.ProductResponseDto;
import com.thekingmoss.entity.Category;
import com.thekingmoss.entity.Product;
import com.thekingmoss.mapper.category.CategoryMapper;
import com.thekingmoss.mapper.product.ProductMapper;
import com.thekingmoss.repository.IProductRepository;
import com.thekingmoss.service.ICategoryService;
import com.thekingmoss.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ICategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toDo)
                .toList();
    }

    @Override
    public ProductResponseDto getById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDo)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

    @Override
    public ProductResponseDto create(ProductRequestDto requestDto) {
        CategoryResponseDto categoryResponseDto = categoryService.getById(requestDto.getCategoryId());
        Category category = categoryMapper.toEntityCategory(categoryResponseDto);
        Product product = productMapper.toEntity(requestDto, category);
        return productMapper.toDo(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        if(!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with ID : " + id);
        }
        productRepository.deleteById(id);
    }
}
