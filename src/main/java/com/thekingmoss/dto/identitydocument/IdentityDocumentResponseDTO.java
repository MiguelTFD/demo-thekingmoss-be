package com.thekingmoss.dto.identitydocument;

import com.thekingmoss.entity.types.IdentityDocumentType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdentityDocumentResponseDTO {
    private Long identityDocumentId;
    private String identityDocumentNumber;
    private IdentityDocumentType identityDocumentType;
    
    //Client
    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    //Role
    private Long roleId;
    private String roleName;
}
