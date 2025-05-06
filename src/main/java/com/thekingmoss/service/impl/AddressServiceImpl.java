package com.thekingmoss.service.impl;

import com.thekingmoss.dto.address.AddressRequestDTO;
import com.thekingmoss.dto.address.AddressResponseDTO;
import com.thekingmoss.entity.Address;
import com.thekingmoss.entity.Client;
import com.thekingmoss.exception.ResourceNotFoundException;
import com.thekingmoss.mapper.address.AddressMapper;
import com.thekingmoss.repository.IAddressRepository;
import com.thekingmoss.repository.IClientRepository;
import com.thekingmoss.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {
    private final IAddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final IClientRepository userRepository;

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
                .findAddressByClient_UserId(id)
                .stream()
                .map(addressMapper::toDto)
                .toList();
    }

    @Override
    public AddressResponseDTO getAddressById(Long id) {
        return addressRepository.findById(id)
                .map(addressMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found by ID : " + id));
    }

    @Override
    public AddressResponseDTO saveAddress(AddressRequestDTO requestDTO) {
        Client client = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found by ID : " + requestDTO.getUserId()));
        Address address = addressMapper.toEntity(requestDTO, client);
        return addressMapper.toDto(addressRepository.save(address));
    }

    public AddressResponseDTO updateAddressById(Long id, AddressRequestDTO requestDTO) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found by ID : " + id));
        Client client = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found by ID : " + id));

        address.setCountry(requestDTO.getCountry());
        address.setState(requestDTO.getState());
        address.setProvince(requestDTO.getProvince());
        address.setDistrict(requestDTO.getDistrict());
        address.setAddressLine(requestDTO.getAddressLine());
        address.setAddressReference(requestDTO.getAddressReference());
        address.setAddressType(requestDTO.getAddressType());
        address.setClient(client);

        return addressMapper.toDto(addressRepository.save(address));
    }

    @Override
    public void deleteAddressById(Long id) {
        if (!addressRepository.existsById(id))
            throw new ResourceNotFoundException("Address not found by ID : " + id);
        addressRepository.deleteById(id);
    }
}
