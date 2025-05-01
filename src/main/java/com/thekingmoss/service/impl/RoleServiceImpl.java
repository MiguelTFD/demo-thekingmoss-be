package com.thekingmoss.service.impl;

import com.thekingmoss.dto.role.RoleRequestDto;
import com.thekingmoss.dto.role.RoleResponseDto;
import com.thekingmoss.entity.Role;
import com.thekingmoss.mapper.role.RoleMapper;
import com.thekingmoss.repository.IRoleRepository;
import com.thekingmoss.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final IRoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    @Transactional
    public RoleResponseDto createRole(RoleRequestDto roleRequestDto) {
        Role role = roleMapper.toEntity(roleRequestDto);
        role = roleRepository.save(role);
        return roleMapper.toDto(role);
    }

    @Override
    public List<RoleResponseDto> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponseDto getRoleById(Long roleId) {
        return roleRepository.findById(roleId)
                .map(roleMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    @Override
    public RoleResponseDto updateRole(Long roleId, RoleRequestDto dto) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        role.setName(dto.getName());
        return roleMapper.toDto(roleRepository.save(role));
    }

    @Override
    public void deleteRole(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        roleRepository.delete(role);
    }
}
