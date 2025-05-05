package com.thekingmoss.dto.user;


import com.thekingmoss.dto.role.RoleResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {

    private Long userId;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private RoleResponseDto role;

}
