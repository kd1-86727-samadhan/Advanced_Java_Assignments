package com.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "players")

// Owning class
public class Players extends BaseEntity {

	@Column(length = 20, name = "first_name")
	private String firstName;

	@Column(length = 20, name = "last_name")
	private String lastName;

	private LocalDate dob;

	@Column(name = "batting_average")
	private double battingAverage;

	@Column(name = "wicket_taken")
	private int wicketTaken;

	@ManyToOne // mandatory
	@JoinColumn(name = "team_id") // Defines the foreign key column in the players table
								// Links the players table to the ipl_team(Team class in com.entites package) 
								// table by referencing the primary key (id) of the Team.
	
	private Team team;	// Holds the reference to the Team object, 
						// Representing the association between a player and their team.

	public Players(String firstName, String lastName, LocalDate dob, double battingAverage, int wicketTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAverage = battingAverage;
		this.wicketTaken = wicketTaken;
	}

}
