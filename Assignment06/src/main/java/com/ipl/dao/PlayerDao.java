package com.ipl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipl.pojos.Players;

public interface PlayerDao extends JpaRepository<Players, Long> {

}
