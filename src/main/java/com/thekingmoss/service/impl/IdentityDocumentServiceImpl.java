package com.thekingmoss.service.impl;

import com.thekingmoss.dto.identitydocument.IdentityDocumentRequestDTO;
import com.thekingmoss.dto.identitydocument.IdentityDocumentResponseDTO;
import com.thekingmoss.entity.User;
import com.thekingmoss.mapper.identitydocument.IdentityDocumentMapper;
import com.thekingmoss.repository.IIdentityDocumentRepository;
import com.thekingmoss.service.IIdentityDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdentityDocumentServiceImpl implements IIdentityDocumentService {
    private final IIdentityDocumentRepository identityDocumentRepository;
    private final IdentityDocumentMapper identityDocumentMapper;

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
                .orElseThrow(() -> new RuntimeException("Identity document not found by ID : " + id)));
    }

    //TODO: Complete when User Class is ready
    @Override
    public IdentityDocumentResponseDTO saveIdentityDocument(IdentityDocumentRequestDTO requestDTO, User user) {
        return null;
    }

    //TODO: Complete when User Class is ready
    @Override
    public IdentityDocumentResponseDTO updateIdentityDocumentById(Long id, IdentityDocumentRequestDTO requestDTO) {
        return null;
    }
    
    @Override
    public void deleteIdentityDocumentById(Long id) {
        if(!identityDocumentRepository.existsById(id)) 
            throw new RuntimeException("Identity document not found by ID : " + id);
        identityDocumentRepository.deleteById(id);
    }
}
