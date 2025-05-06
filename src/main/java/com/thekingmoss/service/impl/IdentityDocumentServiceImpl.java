package com.thekingmoss.service.impl;

import com.thekingmoss.dto.identitydocument.IdentityDocumentRequestDTO;
import com.thekingmoss.dto.identitydocument.IdentityDocumentResponseDTO;
import com.thekingmoss.entity.Client;
import com.thekingmoss.entity.IdentityDocument;
import com.thekingmoss.exception.ResourceNotFoundException;
import com.thekingmoss.mapper.identitydocument.IdentityDocumentMapper;
import com.thekingmoss.mapper.user.ClientMapper;
import com.thekingmoss.repository.IIdentityDocumentRepository;
import com.thekingmoss.repository.IClientRepository;
import com.thekingmoss.service.IIdentityDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdentityDocumentServiceImpl implements IIdentityDocumentService {
    private final IIdentityDocumentRepository identityDocumentRepository;
    private final IdentityDocumentMapper identityDocumentMapper;
    private final IClientRepository userRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<IdentityDocumentResponseDTO> listIdentityDocuments() {
        return identityDocumentRepository.findAll()
                .stream()
                .map(identityDocumentMapper::toDto)
                .toList();
    }

    @Override
    public IdentityDocumentResponseDTO getIdentityDocumentById(Long id) {
        return identityDocumentMapper.toDto(identityDocumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Identity document not found by ID : " + id)));
    }

    @Override
    public IdentityDocumentResponseDTO saveIdentityDocument(IdentityDocumentRequestDTO requestDTO) {
        Client client = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Client not found by ID : " + requestDTO.getUserId()));
        IdentityDocument identityDocument = identityDocumentMapper.toEntity(requestDTO, client);
        IdentityDocument savedIdentityDocument = identityDocumentRepository.save(identityDocument);

        return identityDocumentMapper.toDto(savedIdentityDocument);
    }

    @Override
    public IdentityDocumentResponseDTO updateIdentityDocumentById(Long id, IdentityDocumentRequestDTO requestDTO) {
        IdentityDocument identityDocument = identityDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Identity document not found by ID : " + id));
        Client client = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Client not found by ID : " + id));

        identityDocument.setIdentityDocumentNumber(requestDTO.getIdentityDocumentNumber());
        identityDocument.setIdentityDocumentType(requestDTO.getIdentityDocumentType());
        identityDocument.setClient(client);
        IdentityDocument updatedIdentityDocument = identityDocumentRepository.save(identityDocument);

        return identityDocumentMapper.toDto(updatedIdentityDocument);
    }
    
    @Override
    public void deleteIdentityDocumentById(Long id) {
        if(!identityDocumentRepository.existsById(id)) 
            throw new ResourceNotFoundException("Identity document not found by ID : " + id);
        identityDocumentRepository.deleteById(id);
    }
}
