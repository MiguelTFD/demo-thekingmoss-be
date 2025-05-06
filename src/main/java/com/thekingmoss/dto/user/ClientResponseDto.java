package com.thekingmoss.dto.user;


import com.thekingmoss.dto.role.RoleResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientResponseDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private RoleResponseDto role;

}
