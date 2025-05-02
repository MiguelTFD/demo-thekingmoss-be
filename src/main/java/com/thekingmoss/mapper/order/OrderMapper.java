package com.thekingmoss.mapper.order;

import com.thekingmoss.dto.*;
import com.thekingmoss.dto.order.OrderRequestDto;
import com.thekingmoss.dto.order.OrderResponseDto;
import com.thekingmoss.entity.Order;
import com.thekingmoss.entity.User;
import com.thekingmoss.mapper.orderDetail.OrderDetailMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@RequiredArgsConstructor
public class OrderMapper {

    public Order toEntity(OrderRequestDTO dto, User user) {
        return Order.builder()
                .orderDate(dto.getOrderDate())
                .deliveryType(dto.getDeliveryType())
                .orderInfo(dto.getOrderInfo())
                .deliveryInstructions(dto.getDeliveryInstructions())
                .orderStatus(dto.getOrderStatus())
                .user(user)
                .build();
    }

    public OrderResponseDTO toDto(Order order) {
        return OrderResponseDTO.builder()
                .orderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .deliveryType(order.getDeliveryType())
                .orderInfo(order.getOrderInfo())
                .deliveryInstructions(order.getDeliveryInstructions())
                .orderStatus(order.getOrderStatus())
                .userId(order.getUser().getUserId())
                .details(order.getOrderDetails()
                        .stream()
                        .map(this::toDetailDto)
                        .collect(Collectors.toList())
                )
                .build();
    }

    private OrderDetailResponseDTO toDetailDto(OrderDetail detail) {
        return OrderDetailResponseDTO.builder()
                .productId(detail.getProduct().getProductId())
                .productName(detail.getProduct().getName())
                .quantity(detail.getQuantity())
                .unitPrice(detail.getProduct().getUnitPrice())
                .build();
    }
}
