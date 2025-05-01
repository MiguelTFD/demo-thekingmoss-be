package com.thekingmoss.mapper.identitydocument;

import com.thekingmoss.dto.identitydocument.IdentityDocumentRequestDTO;
import com.thekingmoss.dto.identitydocument.IdentityDocumentResponseDTO;
import com.thekingmoss.entity.IdentityDocument;
import com.thekingmoss.entity.User;
import org.springframework.stereotype.Component;

@Component
public class IdentityDocumentMapper {
    public IdentityDocumentResponseDTO toDto(IdentityDocument identityDocument) {
        return IdentityDocumentResponseDTO.builder()
                .identityDocumentId(identityDocument.getIdentityDocumentId())
                .identityDocumentNumber(identityDocument.getIdentityDocumentNumber())
                .identityDocumentType(identityDocument.getIdentityDocumentType())
                .userId(identityDocument.getUser().getUserId())
                .username(identityDocument.getUser().getUsername())
                .password(identityDocument.getUser().getPassword())
                .firstName(identityDocument.getUser().getFirstName())
                .lastName(identityDocument.getUser().getLastName())
                .phone(identityDocument.getUser().getPhone())
                .email(identityDocument.getUser().getEmail())
                .roleId(identityDocument.getUser().getRole().getRoleId())
                .roleName(identityDocument.getUser().getRole().getName())
                .build();
    }

    public IdentityDocument toEntity(IdentityDocumentRequestDTO requestDTO, User user) {
        return IdentityDocument.builder()
                .identityDocumentNumber(requestDTO.getIdentityDocumentNumber())
                .identityDocumentType(requestDTO.getIdentityDocumentType())
                .user(user)
                .build();
    }
}
