package com.ipl.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TeamRequestDto {

	private String name;
	private String abbrevation;
	private int playerAge;
	private double battingAvg;
	private int wicketsTaken;
}
