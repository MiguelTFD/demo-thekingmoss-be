package com.thekingmoss.dto.role;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RoleResponseDto {

    private Long roleId;

    private String name;

}
