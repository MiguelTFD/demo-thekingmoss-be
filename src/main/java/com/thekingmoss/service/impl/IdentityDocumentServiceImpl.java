package com.thekingmoss.service.impl;

import com.thekingmoss.dto.identitydocument.IdentityDocumentRequestDTO;
import com.thekingmoss.dto.identitydocument.IdentityDocumentResponseDTO;
import com.thekingmoss.entity.IdentityDocument;
import com.thekingmoss.entity.User;
import com.thekingmoss.service.IIdentityDocumentService;

import java.util.List;

public class IdentityDocumentServiceImpl implements IIdentityDocumentService {
    @Override
    public List<IdentityDocument> listIdentityDocuments() {
        return List.of();
    }

    @Override
    public IdentityDocumentResponseDTO getIdentityDocumentById(Long id) {
        return null;
    }

    @Override
    public IdentityDocumentResponseDTO saveIdentityDocument(IdentityDocumentRequestDTO requestDTO, User user) {
        return null;
    }

    @Override
    public IdentityDocumentResponseDTO updateIdentityDocumentById(Long id, IdentityDocumentRequestDTO requestDTO) {
        return null;
    }

    @Override
    public void deleteIdentityDocumentById(Long id) {

    }
}
