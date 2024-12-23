package com.ipl.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipl.dao.PlayerDao;
import com.ipl.dao.TeamDao;
import com.ipl.dto.ApiResponse;
import com.ipl.dto.PlayerRequestDto;
import com.ipl.pojos.Players;
import com.ipl.pojos.Teams;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playerDao;
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse addNewplayer(PlayerRequestDto playerDto) {
		Teams team = teamDao.findById(playerDto.getTeamId()).orElseThrow(() -> new RuntimeException("Invalid Team ID"));

		Players player = modelMapper.map(playerDto, Players.class);
		team.addPlayers(player);
		return new ApiResponse("Team Added Successfully");
	}

}
