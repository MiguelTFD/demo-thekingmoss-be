package com.thekingmoss.dto.address;

import com.thekingmoss.entity.types.AddressType;
import lombok.Data;

@Data
public class AddressRequestDTO {
    private String country;
    private String state;
    private String province;
    private String district;
    private String addressLine;
    private String addressReference;
    private AddressType addressType;
    private Long userId;
}
