package com.thekingmoss.entity;

import com.thekingmoss.entity.types.IdentityDocumentType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "identity_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdentityDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identity_document_id")
	private Long identityDocumentId;

	@Column(name = "identity_document_number", nullable = false)
	private String identityDocumentNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "identity_document_type", nullable = false)
	private IdentityDocumentType identityDocumentType;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private User user;

}
