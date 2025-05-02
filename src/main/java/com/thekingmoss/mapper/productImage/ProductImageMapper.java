package com.thekingmoss.mapper.productImage;

import com.thekingmoss.dto.product.ProductRequestDto;
import com.thekingmoss.dto.productImage.ProductImageRequestDto;
import com.thekingmoss.dto.productImage.ProductImageResponseDto;
import com.thekingmoss.entity.Product;
import com.thekingmoss.entity.ProductImage;
import org.springframework.stereotype.Component;

@Component
public class ProductImageMapper {

    public ProductImageResponseDto toDto(ProductImage productImage){
        return ProductImageResponseDto.builder()
                .id(productImage.getProductImageId())
                .imageUrl(productImage.getImageUrl())
                .productId(productImage.getProduct().getProductId())
                .productName(productImage.getProduct().getName())
                .build();
    }
    public ProductImage toEntity(ProductImageRequestDto requestDto, Product product){
        return ProductImage.builder()
                .imageUrl(requestDto.getImageUrl())
                .product(product)
                .build();
    }
}
