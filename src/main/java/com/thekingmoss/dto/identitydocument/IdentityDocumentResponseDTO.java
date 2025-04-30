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
    
    //User
    private Long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    //Role
    private String roleId;
    private String roleName;
}
