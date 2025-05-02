package com.thekingmoss.dto.productImage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductImageResponseDto {

    private Long id;
    private String imageUrl;
    private Long productId;
    private String productName;
}
