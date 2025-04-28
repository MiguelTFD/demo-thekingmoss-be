package com.thekingmoss.entity;

import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetailId implements Serializable {
	
	@Column(name = "order_id")
	private Long orderId;

	@Column(name = "product_id")
	private Long productId;

}
