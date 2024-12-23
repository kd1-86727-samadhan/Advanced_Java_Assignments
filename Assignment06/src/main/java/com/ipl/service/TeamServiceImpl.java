package com.ipl.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ipl.dao.TeamDao;
import com.ipl.dto.ApiResponse;
import com.ipl.dto.TeamRequestDto;
import com.ipl.dto.TeamResponseDto;
import com.ipl.pojos.Teams;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao teamDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<TeamResponseDto> getAllTeams() {
		return teamDao.findAll().stream().map(team -> modelMapper.map(team, TeamResponseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse addTeam(TeamRequestDto dtoteam) {
		Teams team = modelMapper.map(dtoteam, Teams.class);
		Teams teams = teamDao.save(team);
		return new ApiResponse("Team Added Successfully");
	}

	@Override
	public ApiResponse deleteTeam(Long id) {
		if (teamDao.existsById(id)) {
			teamDao.deleteById(id);
			return new ApiResponse("Team Deleted Successfully");
		} else {
			return new ApiResponse("Invalid Id;");
		}
	}

	@Override
	public String updateTeam(Long id) {
		Optional<Teams> save = teamDao.findById(id);
		if (save.isEmpty()) {

		}
		return "Team Updated Succesfully";
	}
}
