package com.thekingmoss.entity;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "stock", nullable = false)
	private Integer stock;

	@Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

	@Column(name = "discount", nullable = false, precision = 5, scale = 2)
    private BigDecimal discount;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "size")
	private String size;
	
	@Column(name = "weight", precision = 10, scale = 2)
	private BigDecimal weight;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<ProductImage> productImages;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderDetail> orderDetails;
}
