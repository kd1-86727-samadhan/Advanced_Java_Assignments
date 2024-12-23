package com.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.dto.ApiResponse;
import com.ipl.dto.TeamRequestDto;
import com.ipl.dto.TeamResponseDto;
import com.ipl.pojos.Teams;
import com.ipl.service.TeamService;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@GetMapping
	public ResponseEntity<?> getTeams() {
		List<TeamResponseDto> teams = teamService.getAllTeams();
		if (teams.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(teams);

	}

	@PostMapping
	public ResponseEntity<?> addTeam(@RequestBody TeamRequestDto team) {
		return ResponseEntity.status(HttpStatus.CREATED).body(teamService.addTeam(team));
	}

	@DeleteMapping
	public ResponseEntity<?> deleteTeamById(@RequestParam() Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(teamService.deleteTeam(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

//	@RequestMapping
//	public ResponseEntity<?> updateTeam(@RequestBody Teams team) {
//		return ResponseEntity.status(HttpStatus.OK).body(teamService.deleteTeam(id));
//	}

}
