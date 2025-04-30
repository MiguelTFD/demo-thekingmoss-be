package com.thekingmoss.dto.address;

import com.thekingmoss.entity.types.AddressType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponseDTO {
    private Long addressId;
    private String country;
    private String state;
    private String province;
    private String district;
    private String addressLine;
    private String addressReference;
    private AddressType addressType;
    
    //User
    private Long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    
    //Role
    private String roleId;
    private String roleName;
}
