package com.thekingmoss.mapper.identitydocument;

import com.thekingmoss.dto.identitydocument.IdentityDocumentRequestDTO;
import com.thekingmoss.dto.identitydocument.IdentityDocumentResponseDTO;
import com.thekingmoss.entity.Client;
import com.thekingmoss.entity.IdentityDocument;
import org.springframework.stereotype.Component;

@Component
public class IdentityDocumentMapper {
    public IdentityDocumentResponseDTO toDto(IdentityDocument identityDocument) {
        return IdentityDocumentResponseDTO.builder()
                .identityDocumentId(identityDocument.getIdentityDocumentId())
                .identityDocumentNumber(identityDocument.getIdentityDocumentNumber())
                .identityDocumentType(identityDocument.getIdentityDocumentType())
                .userId(identityDocument.getClient().getUserId())
                .firstName(identityDocument.getClient().getFirstName())
                .lastName(identityDocument.getClient().getLastName())
                .phone(identityDocument.getClient().getPhone())
                .email(identityDocument.getClient().getEmail())
                .roleId(identityDocument.getClient().getRole().getRoleId())
                .roleName(identityDocument.getClient().getRole().getName())
                .build();
    }

    public IdentityDocument toEntity(IdentityDocumentRequestDTO requestDTO, Client client) {
        return IdentityDocument.builder()
                .identityDocumentNumber(requestDTO.getIdentityDocumentNumber())
                .identityDocumentType(requestDTO.getIdentityDocumentType())
                .client(client)
                .build();
    }
}
