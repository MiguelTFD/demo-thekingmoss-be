package com.thekingmoss.service;

import com.thekingmoss.dto.role.RoleRequestDto;
import com.thekingmoss.dto.role.RoleResponseDto;

import java.util.List;

public interface RoleService {

    RoleResponseDto createRole(RoleRequestDto dto);

    List<RoleResponseDto> getAllRoles();

    RoleResponseDto getRoleById(Long roleId);

    RoleResponseDto updateRole(Long roleId, RoleRequestDto dto);

    void deleteRole(Long roleId);

}
