package com.ecom.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BaseEntity {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	@Column(name = "creation_on")
	private LocalDate creationOn;

	@UpdateTimestamp
	@Column(name = "update_on")
	private LocalDateTime updateOn;
}
