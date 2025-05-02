package com.thekingmoss.service;

import com.thekingmoss.dto.product.ProductRequestDto;
import com.thekingmoss.dto.product.ProductResponseDto;

import java.util.List;

public interface IProductService {
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto getProductById(Long id);
    List<ProductResponseDto> listProductsByCategoryName(String categoryName);
    ProductResponseDto createProduct(ProductRequestDto requestDto);
    ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto);
    void deleteProduct(Long id);
}
