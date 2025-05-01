package com.thekingmoss.service;

import com.thekingmoss.dto.address.AddressRequestDTO;
import com.thekingmoss.dto.address.AddressResponseDTO;

import java.util.List;

public interface IAddressService {
    List<AddressResponseDTO> listAddresses();
    List<AddressResponseDTO> listAddressesByUserId(Long id);
    AddressResponseDTO getAddressById(Long id);
    AddressResponseDTO getAddressByUserId(Long id);
    AddressResponseDTO saveAddress(AddressRequestDTO requestDTO);
    AddressResponseDTO updateAddress(AddressRequestDTO requestDTO);
    AddressResponseDTO deleteAddress(Long id);
    AddressResponseDTO deleteAddressByUserId(Long id);
}
