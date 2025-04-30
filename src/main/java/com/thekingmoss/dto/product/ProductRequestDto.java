package com.thekingmoss.dto.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDto {
    private String name;
    private Integer stock;
    private BigDecimal unitPrice;
    private BigDecimal discount;
    private String description;
    private String size;
    private BigDecimal weight;
    private Long categoryId;
}
