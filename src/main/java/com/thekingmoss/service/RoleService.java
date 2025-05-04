package com.thekingmoss.service;

import com.thekingmoss.dto.role.RoleRequestDto;
import com.thekingmoss.dto.role.RoleResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {

    RoleResponseDto createRole(RoleRequestDto requestDto);

    RoleResponseDto getRoleById(Long id);

    List<RoleResponseDto> getAllRoles();

    RoleResponseDto updateRole(Long id, RoleRequestDto requestDto);

    void deleteRole(Long id);
}
