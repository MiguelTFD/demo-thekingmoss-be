package com.thekingmoss.service;

import com.thekingmoss.dto.identitydocument.IdentityDocumentRequestDTO;
import com.thekingmoss.dto.identitydocument.IdentityDocumentResponseDTO;
import com.thekingmoss.entity.IdentityDocument;
import com.thekingmoss.entity.User;

import java.util.List;

public interface IIdentityDocumentService {
    List<IdentityDocument> listIdentityDocuments();
    IdentityDocumentResponseDTO getIdentityDocumentById(Long id);
    IdentityDocumentResponseDTO saveIdentityDocument(IdentityDocumentRequestDTO requestDTO, User user);
    IdentityDocumentResponseDTO updateIdentityDocumentByUserId(IdentityDocumentRequestDTO requestDTO);
    void deleteIdentityDocumentById(Long id);
}
