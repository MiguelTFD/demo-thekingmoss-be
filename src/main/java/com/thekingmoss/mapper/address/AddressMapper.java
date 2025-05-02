package com.thekingmoss.mapper.address;

import com.thekingmoss.dto.address.AddressRequestDTO;
import com.thekingmoss.dto.address.AddressResponseDTO;
import com.thekingmoss.entity.Address;
import com.thekingmoss.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressResponseDTO toDto(Address address) {
        return AddressResponseDTO.builder()
                .addressId(address.getAddressId())
                .country(address.getCountry())
                .state(address.getState())
                .province(address.getProvince())
                .district(address.getDistrict())
                .addressLine(address.getAddressLine())
                .addressReference(address.getAddressReference())
                .addressType(address.getAddressType())
                .userId(address.getUser().getUserId())
                .username(address.getUser().getUsername())
                .password(address.getUser().getPassword())
                .firstName(address.getUser().getFirstName())
                .lastName(address.getUser().getLastName())
                .phone(address.getUser().getPhone())
                .email(address.getUser().getEmail())
                .roleId(address.getUser().getRole().getRoleId())
                .roleName(address.getUser().getRole().getName())
                .build();
    }

    public Address toEntity(AddressRequestDTO requestDTO, User user) {
        return Address.builder()
                .country(requestDTO.getCountry())
                .state(requestDTO.getState())
                .province(requestDTO.getProvince())
                .district(requestDTO.getDistrict())
                .addressLine(requestDTO.getAddressLine())
                .addressReference(requestDTO.getAddressReference())
                .addressType(requestDTO.getAddressType())
                .user(user)
                .build();
    }
}
