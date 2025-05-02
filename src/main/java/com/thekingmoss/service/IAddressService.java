package com.thekingmoss.service;

import com.thekingmoss.dto.address.AddressRequestDTO;
import com.thekingmoss.dto.address.AddressResponseDTO;

import java.util.List;

public interface IAddressService {
    List<AddressResponseDTO> listAddresses();
    List<AddressResponseDTO> listAddressesByUserId(Long id);
    AddressResponseDTO getAddressById(Long id);
    AddressResponseDTO saveAddress(AddressRequestDTO requestDTO);
    AddressResponseDTO updateAddressById(Long id, AddressRequestDTO requestDTO);
    void deleteAddressById(Long id);
}
