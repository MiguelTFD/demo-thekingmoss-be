package com.thekingmoss.mapper.user;

import com.thekingmoss.dto.user.ClientRequestDto;
import com.thekingmoss.dto.user.ClientResponseDto;
import com.thekingmoss.entity.Client;
import com.thekingmoss.entity.Role;
import com.thekingmoss.mapper.role.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientMapper {

    private final RoleMapper roleMapper;

    public ClientResponseDto responseDto(Client client) {
        if (client == null) return null;
        return ClientResponseDto.builder()
                .userId(client.getUserId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .phone(client.getPhone())
                .email(client.getEmail())
                .role(roleMapper.responseDto(client.getRole()))
                .build();
    }

    public Client toUserEntity (ClientRequestDto requestDto, Role role) {
        if (requestDto == null || role == null) return null;
        return Client.builder()
                .firstName(requestDto.getFirstName())
                .lastName(requestDto.getLastName())
                .phone(requestDto.getPhone())
                .email(requestDto.getEmail())
                .role(role)
                .build();
    }
}
