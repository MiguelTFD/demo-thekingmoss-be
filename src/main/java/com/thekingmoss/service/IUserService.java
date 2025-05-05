package com.thekingmoss.service;

import com.thekingmoss.dto.user.UserRequestDto;
import com.thekingmoss.dto.user.UserResponseDto;

import java.util.List;

public interface IUserService {

    UserResponseDto createUser(UserRequestDto requestDto);

    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUsers();

    UserResponseDto updateUser(Long id, UserRequestDto requestDto);

    void deleteUser(Long id);
}
