package com.thekingmoss.mapper.orderDetail;

import com.thekingmoss.entity.OrderDetail;
import com.thekingmoss.entity.Order;
import com.thekingmoss.entity.Product;
import com.thekingmoss.dto.orderDetail.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;
import java.math.BigDecimal;

import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OrderDetailMapper {

    public OrderDetail toEntity(OrderDetailRequestDTO dto, Order order, Product product) {
        return OrderDetail.builder()
                .order(order)
                .product(product)
                .quantity(dto.getQuantity())
                .build();
    }

    public OrderDetailResponseDTO toDto(OrderDetail detail) {
        return OrderDetailResponseDTO.builder()
                .productId(detail.getProduct().getProductId())
                .productName(detail.getProduct().getName())
                .quantity(detail.getQuantity())
                .unitPrice(detail.getProduct().getUnitPrice())
                .build();
    }
}

