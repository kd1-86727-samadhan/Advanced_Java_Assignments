package com.ipl.pojos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true, exclude = "players")
@NoArgsConstructor
public class Teams extends BaseEntity {

	@Column(length = 100, unique = true)
	private String name;

	@Column(length = 10, unique = true)
	private String abbrevation;

	@Column(name = "max_player_age")
	private int playerAge;

	@Column(name = "batting_avg")
	private double battingAvg;

	@Column(name = "wicket_taken")
	private int wicketsTaken;

	@OneToMany(mappedBy = "teamId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Players> players = new ArrayList<Players>();

	public Teams(String name, String abbrevation, int playerAge, double battingAvg, int wicketsTaken) {
		this.name = name;
		this.abbrevation = abbrevation;
		this.playerAge = playerAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	public void addPlayers(Players player) {
		this.players.add(player);
		player.setTeamId(this);
	}

	public void removePlayers(Players player) {
		this.players.remove(player);
		player.setTeamId(null);
	}

}
