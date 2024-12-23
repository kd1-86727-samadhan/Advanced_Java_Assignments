package com.ipl.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "teamId")
@NoArgsConstructor
public class PlayerRequestDto {

	private String firstName;

	private String lastName;

	private LocalDate dob;

	private double battingAverage;

	private int wicketsTaken;
	
	private Long teamId;

}
