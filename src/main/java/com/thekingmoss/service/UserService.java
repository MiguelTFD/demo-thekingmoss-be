package com.thekingmoss.service;

import com.thekingmoss.dto.user.UserRequestDto;
import com.thekingmoss.dto.user.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto dto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(Long userId);

    UserResponseDto updateUser(Long userId, UserRequestDto dto);

    void deleteUser(Long userId);
}
