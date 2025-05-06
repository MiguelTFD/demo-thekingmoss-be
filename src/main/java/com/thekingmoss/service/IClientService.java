package com.thekingmoss.service;

import com.thekingmoss.dto.user.ClientRequestDto;
import com.thekingmoss.dto.user.ClientResponseDto;

import java.util.List;

public interface IClientService {

    ClientResponseDto createClient(ClientRequestDto requestDto);

    ClientResponseDto getClientById(Long id);

    List<ClientResponseDto> getAllClients();

    ClientResponseDto updateClient(Long id, ClientRequestDto requestDto);

    void deleteClient(Long id);
}
