package com.thekingmoss.entity;

import com.thekingmoss.entity.types.DocumentType;
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
	private Long id;

	@Column(name = "document_number", nullable = false)
	private String documentNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "document_type", nullable = false)
	private DocumentType documentType;

	@OneToOne
	@JoinColumn(name = "id")
	private User user;

}
