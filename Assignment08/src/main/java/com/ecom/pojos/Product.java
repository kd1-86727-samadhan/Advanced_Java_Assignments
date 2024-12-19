package com.ecom.pojos;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product extends BaseEntity {

	@Column(length = 20, nullable = false)
	private String title;
	
	@Column(length = 20)
	private String description;
	
	private double price;
	
	private int quantity;
	
	private int status;
	
}
