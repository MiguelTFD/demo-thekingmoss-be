package com.thekingmoss.controller;

import com.thekingmoss.dto.productImage.ProductImageRequestDto;
import com.thekingmoss.dto.productImage.ProductImageResponseDto;
import com.thekingmoss.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productImage")
@RequiredArgsConstructor
public class ProductImageController {

    private final ProductImageService service;

    @GetMapping
    public List<ProductImageResponseDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ProductImageResponseDto create(@RequestBody ProductImageRequestDto requestDto) {
        return service.create(requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public ProductImageResponseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }
}


