package com.thekingmoss.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Address> addresses;
	
	@OneToOne(mappedBy = "client")
    private IdentityDocument identityDocument;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Order> orders;
}
