package com.ipl.service;

import java.util.List;

import com.ipl.dto.ApiResponse;
import com.ipl.dto.TeamRequestDto;
import com.ipl.dto.TeamResponseDto;
import com.ipl.pojos.Teams;

public interface TeamService {

	List<TeamResponseDto> getAllTeams();

	ApiResponse addTeam(TeamRequestDto team);

	ApiResponse deleteTeam(Long id);

	String updateTeam(Long id);
}
