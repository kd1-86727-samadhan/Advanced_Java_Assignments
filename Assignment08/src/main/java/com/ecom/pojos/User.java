package com.ecom.pojos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "orderList")
public class User extends BaseEntity {
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(length = 20, unique = true)
	private String email;
	
	@Column(length = 20)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Orders> orderList = new ArrayList<>();
}
