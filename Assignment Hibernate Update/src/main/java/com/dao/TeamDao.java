package com.dao;

import java.util.List;

import com.entities.Team;

public interface TeamDao {
	public String insertTeam(Team team);
	public List<Team> getAllTeam();
	public List<Team> displayAgeAndBattingAvg(int age, double avg);
	public List<Team> displayOwnNameAndAbbreviation(int age, double avg);
	public String updateAge(String name, int age);
	public String deleteById(Long id);
}
