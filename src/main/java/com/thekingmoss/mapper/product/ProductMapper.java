package com.thekingmoss.mapper.product;

import com.thekingmoss.dto.product.ProductRequestDto;
import com.thekingmoss.dto.product.ProductResponseDto;
import com.thekingmoss.entity.Category;
import com.thekingmoss.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponseDto toDo(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .stock(product.getStock())
                .unitPrice(product.getUnitPrice())
                .discount(product.getDiscount())
                .description(product.getDescription())
                .size(product.getSize())
                .weight(product.getWeight())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .build();
    }

    public Product toEntity(ProductRequestDto requestDto, Category category) {
        return Product.builder()
                .name(requestDto.getName())
                .stock(requestDto.getStock())
                .unitPrice(requestDto.getUnitPrice())
                .discount(requestDto.getDiscount())
                .description(requestDto.getDescription())
                .size(requestDto.getSize())
                .weight(requestDto.getWeight())
                .category(category)
                .build();
    }
}
