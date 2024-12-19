package com.ecom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	private String title;

	private String description;

	private double price;

	private int quantity;

	@JsonProperty(access = Access.READ_ONLY)
	private int status;
	
	private Long userId;

}
