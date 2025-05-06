package com.thekingmoss.service;

import com.thekingmoss.dto.identitydocument.IdentityDocumentRequestDTO;
import com.thekingmoss.dto.identitydocument.IdentityDocumentResponseDTO;

import java.util.List;

public interface IIdentityDocumentService {
    List<IdentityDocumentResponseDTO> listIdentityDocuments();
    IdentityDocumentResponseDTO getIdentityDocumentById(Long id);
    IdentityDocumentResponseDTO saveIdentityDocument(IdentityDocumentRequestDTO requestDTO);
    IdentityDocumentResponseDTO updateIdentityDocumentById(Long id, IdentityDocumentRequestDTO requestDTO);
    void deleteIdentityDocumentById(Long id);
}
