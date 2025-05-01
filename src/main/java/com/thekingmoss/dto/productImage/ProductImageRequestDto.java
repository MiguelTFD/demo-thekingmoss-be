package com.thekingmoss.dto.productImage;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductImageRequestDto {

    private String imageUrl;
    private Long productId;
}
