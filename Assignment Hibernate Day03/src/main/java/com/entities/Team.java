package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "ipl_team")
@Entity
@ToString(callSuper = true, exclude = {"player"})
// Inverse class
public class Team extends BaseEntity {

	@Column(length = 100, unique = true)
	private String name;

	@Column(length = 20, unique = true)
	private String abbreviation;

	@Column(length = 20, nullable = false)
	private String owner;

	@Column(name = "max_player_age")
	private int maxPlayerAge;

	@Column(name = "batting_average")
	private double battingAverage;

	@Column(name = "wicket_taken")
	private int wicketsTaken;

	// One team having multiple players
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true) // mandatory otherwise causes - MappingException

	private List<Players> player = new ArrayList<>();

	public Team(String abbreviation, String owner) {
		super();
		this.abbreviation = abbreviation;
		this.owner = owner;
	}

	public Team(String name, String abbreviation, String owner, int maxPlayerAge, double battingAverage,
			int wicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAverage = battingAverage;
		this.wicketsTaken = wicketsTaken;
	}

	public void addPlayer(Players player1) {
		this.player.add(player1);
		player1.setTeam(this);
	}

	public void removePlayer(Players player1)
	{
		this.player.remove(player1);
		player1.setTeam(null);	
	}
}
