package com.thekingmoss.dto.user;

import lombok.Data;

@Data
public class UserRequestDto {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private Long roleId;

}
