package com.thekingmoss.mapper.user;

import com.thekingmoss.dto.user.UserRequestDto;
import com.thekingmoss.dto.user.UserResponseDto;
import com.thekingmoss.entity.Role;
import com.thekingmoss.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toDto(User user){
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .roleId(user.getRole() != null ? user.getRole().getRoleId() : null)
                .build();
    }

    public User toUserRequestDto(UserRequestDto requestDto) {

        Role role = Role.builder()
                .roleId(requestDto.getRoleId())
                .build();

        return User.builder()
                .username(requestDto.getUsername())
                .password(requestDto.getPassword())
                .firstName(requestDto.getFirstName())
                .lastName(requestDto.getLastName())
                .phone(requestDto.getPhone())
                .email(requestDto.getEmail())
                .role(role)
                .build();
    }
}
