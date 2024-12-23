package com.ipl.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BaseDto {

	private Long id;
	private LocalDate createdOn;
	private LocalDateTime updatedOn;
}
