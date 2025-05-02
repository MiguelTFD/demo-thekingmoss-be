package com.thekingmoss.service;

import com.thekingmoss.dto.productImage.ProductImageRequestDto;
import com.thekingmoss.dto.productImage.ProductImageResponseDto;

import java.util.List;

public interface ProductImageService {

    List<ProductImageResponseDto> getAll();

    ProductImageResponseDto create(ProductImageRequestDto requestDto);

    ProductImageResponseDto getById(Long id);

    void delete(Long id);
}
