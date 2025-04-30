package com.thekingmoss.dto.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponseDto {
    private Long id;
    private String name;
    private Integer stock;
    private BigDecimal unitPrice;
    private BigDecimal discount;
    private String description;
    private String size;
    private BigDecimal weight;
    private Long categoryId;
    private String categoryName;
}
