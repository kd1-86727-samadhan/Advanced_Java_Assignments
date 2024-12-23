package com.ipl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.dto.PlayerRequestDto;
import com.ipl.service.PlayerService;


@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping
	public ResponseEntity<?> addPlayer(@RequestBody PlayerRequestDto player) {

		return ResponseEntity.status(HttpStatus.CREATED).body(playerService.addNewplayer(player));
	}
}
