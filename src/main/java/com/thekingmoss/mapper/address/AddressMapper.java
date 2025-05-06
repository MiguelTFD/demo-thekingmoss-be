package com.thekingmoss.mapper.address;

import com.thekingmoss.dto.address.AddressRequestDTO;
import com.thekingmoss.dto.address.AddressResponseDTO;
import com.thekingmoss.entity.Address;
import com.thekingmoss.entity.Client;
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
                .userId(address.getClient().getUserId())
                .firstName(address.getClient().getFirstName())
                .lastName(address.getClient().getLastName())
                .phone(address.getClient().getPhone())
                .email(address.getClient().getEmail())
                .roleId(address.getClient().getRole().getRoleId())
                .roleName(address.getClient().getRole().getName())
                .build();
    }

    public Address toEntity(AddressRequestDTO requestDTO, Client client) {
        return Address.builder()
                .country(requestDTO.getCountry())
                .state(requestDTO.getState())
                .province(requestDTO.getProvince())
                .district(requestDTO.getDistrict())
                .addressLine(requestDTO.getAddressLine())
                .addressReference(requestDTO.getAddressReference())
                .addressType(requestDTO.getAddressType())
                .client(client)
                .build();
    }
}
