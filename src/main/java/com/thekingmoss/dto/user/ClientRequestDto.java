package com.thekingmoss.dto.user;

import lombok.Data;

@Data
public class ClientRequestDto {

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private Long roleId;

}
