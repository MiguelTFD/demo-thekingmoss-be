package com.thekingmoss.mapper.order;

import com.thekingmoss.dto.order.OrderRequestDto;
import com.thekingmoss.dto.order.OrderResponseDto;
import com.thekingmoss.dto.orderDetail.OrderDetailResponseDto;
import com.thekingmoss.entity.Order;
import com.thekingmoss.entity.OrderDetail;
import com.thekingmoss.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class OrderMapper {

    public Order toEntity(OrderRequestDto dto, Client client) {
        return Order.builder()
                .orderDate(dto.getOrderDate())
                .deliveryType(dto.getDeliveryType())
                .orderInfo(dto.getOrderInfo())
                .deliveryInstructions(dto.getDeliveryInstructions())
                .orderStatus(dto.getOrderStatus())
                .client(client)
                .build();
    }

    public OrderResponseDto toDto(Order order) {
        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .deliveryType(order.getDeliveryType())
                .orderInfo(order.getOrderInfo())
                .deliveryInstructions(order.getDeliveryInstructions())
                .orderStatus(order.getOrderStatus())
                .userId(order.getClient().getUserId())
                .details(order.getOrderDetails()
                        .stream()
                        .map(this::toDetailDto)
                        .collect(Collectors.toList())
                )
                .build();
    }

    private OrderDetailResponseDto toDetailDto(OrderDetail detail) {
        return OrderDetailResponseDto.builder()
                .productId(detail.getProduct().getProductId())
                .productName(detail.getProduct().getName())
                .quantity(detail.getQuantity())
                .unitPrice(detail.getProduct().getUnitPrice())
                .build();
    }
}
