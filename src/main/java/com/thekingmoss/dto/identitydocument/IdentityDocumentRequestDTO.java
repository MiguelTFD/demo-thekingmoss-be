package com.thekingmoss.dto.identitydocument;

import com.thekingmoss.entity.types.IdentityDocumentType;
import lombok.Data;

@Data
public class IdentityDocumentRequestDTO {
    private String identityDocumentNumber;
    private IdentityDocumentType identityDocumentType;
    private Long userId;
}
