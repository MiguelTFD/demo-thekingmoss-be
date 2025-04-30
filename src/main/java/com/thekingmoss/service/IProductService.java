package com.thekingmoss.service;

import com.thekingmoss.dto.product.ProductRequestDto;
import com.thekingmoss.dto.product.ProductResponseDto;

import java.util.List;

public interface IProductService {
    List<ProductResponseDto> getAll();
    ProductResponseDto getById(Long id);
    ProductResponseDto create(ProductRequestDto requestDto);
    void delete(Long id);
}
