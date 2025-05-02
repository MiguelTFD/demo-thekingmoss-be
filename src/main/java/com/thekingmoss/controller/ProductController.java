package com.thekingmoss.controller;

import com.thekingmoss.dto.product.ProductRequestDto;
import com.thekingmoss.dto.product.ProductResponseDto;
import com.thekingmoss.dto.productImage.ProductImageResponseDto;
import com.thekingmoss.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService service;

    @GetMapping
    public List<ProductResponseDto> getAll() {
        return service.getAllProducts();
    }

    @PostMapping
    public ProductResponseDto create(@RequestBody ProductRequestDto requestDto) {
        return service.createProduct(requestDto);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @GetMapping("/category/{categoryName}")
    public List<ProductResponseDto> listProductsByCategoryName(@PathVariable String categoryName) {
        return service.listProductsByCategoryName(categoryName);
    }

    @PutMapping("/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto requestDto) {
        return service.updateProduct(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProduct(id);
    }
}
