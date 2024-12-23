package com.ipl.pojos;

import java.time.LocalDate;

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
@ToString
@NoArgsConstructor
public class Players extends BaseEntity {

	@Column(name = "first_name", length = 20)
	private String firstName;

	@Column(name = "last_name", length = 20)
	private String lastName;

	private LocalDate dob;

	@Column(name = "batting_avg")
	private double battingAverage;

	@Column(name = "wickets_taken")
	private int wicketsTaken;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Teams teamId;

	public Players(String firstName, String lastName, LocalDate dob, double battingAverage, int wicketsTaken) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAverage = battingAverage;
		this.wicketsTaken = wicketsTaken;
	}

}
