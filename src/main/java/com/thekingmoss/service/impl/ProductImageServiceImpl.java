package com.thekingmoss.service.impl;

import com.thekingmoss.dto.product.ProductResponseDto;
import com.thekingmoss.dto.productImage.ProductImageRequestDto;
import com.thekingmoss.dto.productImage.ProductImageResponseDto;
import com.thekingmoss.entity.Product;
import com.thekingmoss.entity.ProductImage;
import com.thekingmoss.mapper.product.ProductMapper;
import com.thekingmoss.mapper.productImage.ProductImageMapper;
import com.thekingmoss.repository.ProductImageRepository;
import com.thekingmoss.service.IProductService;
import com.thekingmoss.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageRepository productImageRepository;
    private final IProductService productService;
    private final ProductMapper productMapper;
    private final ProductImageMapper productImageMapper;


    @Override
    public List<ProductImageResponseDto> getAll() {
        return productImageRepository.findAll().stream()
                .map(productImageMapper::toDto)
                .toList();
    }

    @Override
    public ProductImageResponseDto create(ProductImageRequestDto requestDto) {
        ProductResponseDto productResponseDto = productService.getProductById(requestDto.getProductId());
        Product product = productMapper.toEntity(productResponseDto);
        ProductImage productImage = productImageMapper.toEntity(requestDto,product);
        return productImageMapper.toDto(productImageRepository.save(productImage));

    }

    @Override
    public ProductImageResponseDto getById(Long id) {
        return productImageRepository.findById(id)
                .map(productImageMapper::toDto)
                .orElseThrow(() -> new RuntimeException("ProductImage not found with ID:" + id));
    }


    @Override
    public void delete(Long id) {
        if (!productImageRepository.existsById(id)){
            throw new RuntimeException("ProductImage not found with ID: " + id);
        }
        productImageRepository.deleteById(id);

    }
}
