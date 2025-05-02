package com.thekingmoss.service.impl;

import com.thekingmoss.dto.address.AddressRequestDTO;
import com.thekingmoss.dto.address.AddressResponseDTO;
import com.thekingmoss.entity.Address;
import com.thekingmoss.mapper.address.AddressMapper;
import com.thekingmoss.repository.IAddressRepository;
import com.thekingmoss.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {
    private final IAddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public List<AddressResponseDTO> listAddresses() {
        return addressRepository
                .findAll()
                .stream()
                .map(addressMapper::toDto)
                .toList();
    }

    @Override
    public List<AddressResponseDTO> listAddressesByUserId(Long id) {
        return addressRepository
                .findAddressByUser_UserId(id)
                .stream()
                .map(addressMapper::toDto)
                .toList();
    }

    @Override
    public AddressResponseDTO getAddressById(Long id) {
        return addressRepository.findById(id)
                .map(addressMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Address not found by ID : " + id));
    }

    //TODO: Uncomment when User Class is implemented
    @Override
    public AddressResponseDTO saveAddress(AddressRequestDTO requestDTO) {
        // User user = userRepository.findById(requestDTO.userID)
        //        .orElseThrow(() -> new RuntimeException("User not found by ID : " + id));
        // Address address = addressMapper.toEntity(requestDTO, user);
        // return addressMapper.toDto(addressRepository.save(address));
        return null;
    }

    //TODO: Method does not work, Uncomment lines when User Class is implemented 
    @Override
    public AddressResponseDTO updateAddressById(Long id, AddressRequestDTO requestDTO) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found by ID : " + id));
        // User user = userRepository.findById(requestDTO.userID)
        //        .orElseThrow(() -> new RuntimeException("User not found by ID : " + id));
        
        // address = addressMapper.toEntity(requestDTO, user);
        return addressMapper.toDto(addressRepository.save(address));
    }

    @Override
    public void deleteAddressById(Long id) {
        if(!addressRepository.existsById(id))
            throw new RuntimeException("Address not found by ID : " + id);
        addressRepository.deleteById(id);
    }
}
