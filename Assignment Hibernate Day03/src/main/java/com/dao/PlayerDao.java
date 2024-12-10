package com.dao;

import com.entities.Players;

public interface PlayerDao {

	String addNewPlayer(Long teamId, Players player);

	String removePlayer(Long teamId, Long playerId);

}
