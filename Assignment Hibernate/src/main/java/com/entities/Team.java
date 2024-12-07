package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ipl_team")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Long teamId;

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
	private int wickets;

	public Team() {
		// TODO Auto-generated constructor stub
	}

	public Team(String name, String abbreviation, String owner, int maxPlayerAge, double battingAverage,
			int wickets) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAverage = battingAverage;
		this.wickets = wickets;
	}

	public Team(Long teamId, String name, String abbreviation, String owner, int maxPlayerAge, double battingAverage,
			int wickets) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAverage = battingAverage;
		this.wickets = wickets;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxPlayerAge() {
		return maxPlayerAge;
	}

	public void setMaxPlayerAge(int maxPlayerAge) {
		this.maxPlayerAge = maxPlayerAge;
	}

	public double getBattingAverage() {
		return battingAverage;
	}

	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	@Override
	public String toString() {
		return "IplTeam [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxPlayerAge=" + maxPlayerAge + ", battingAverage=" + battingAverage + ", wickets=" + wickets
				+ "]";
	}

}
