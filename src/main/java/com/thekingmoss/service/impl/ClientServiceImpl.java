package com.thekingmoss.service.impl;

import com.thekingmoss.dto.user.ClientRequestDto;
import com.thekingmoss.dto.user.ClientResponseDto;
import com.thekingmoss.entity.Role;
import com.thekingmoss.entity.Client;
import com.thekingmoss.exception.ResourceNotFoundException;
import com.thekingmoss.mapper.user.ClientMapper;
import com.thekingmoss.repository.IRoleRepository;
import com.thekingmoss.repository.IClientRepository;
import com.thekingmoss.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;
    private final IRoleRepository roleRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponseDto createClient(ClientRequestDto requestDto) {
        Role role = roleRepository.findById(requestDto.getRoleId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));

        Client client = clientMapper.toUserEntity(requestDto, role);
        client = clientRepository.save(client);
        return clientMapper.responseDto(client);
    }

    @Override
    public ClientResponseDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        return clientMapper.responseDto(client);
    }

    @Override
    public List<ClientResponseDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::responseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponseDto updateClient(Long id, ClientRequestDto requestDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        Role role = roleRepository.findById(requestDto.getRoleId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        client.setFirstName(requestDto.getFirstName());
        client.setLastName(requestDto.getLastName());
        client.setPhone(requestDto.getPhone());
        client.setEmail(requestDto.getEmail());
        client.setRole(role);

        return clientMapper.responseDto(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client not found");
        }
        clientRepository.deleteById(id);
    }
}
