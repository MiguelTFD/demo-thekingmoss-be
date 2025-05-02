package com.thekingmoss.mapper.role;

import com.thekingmoss.dto.role.RoleRequestDto;
import com.thekingmoss.dto.role.RoleResponseDto;
import com.thekingmoss.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public RoleResponseDto toDto(Role role){
        return RoleResponseDto.builder()
                .roleId(role.getRoleId())
                .name(role.getName())
                .build();
    }

    public Role toEntity(RoleRequestDto requestDto) {
        return Role.builder()
                .name(requestDto.getName())
                .build();
    }

}
