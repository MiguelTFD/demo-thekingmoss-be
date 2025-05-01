package com.thekingmoss.repository;

import com.thekingmoss.entity.IdentityDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIdentityDocumentRepository extends JpaRepository<IdentityDocument, Long> {
    
}
