package com.ipl.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipl.dao.OwnerDao;
import com.ipl.dao.TeamDao;
import com.ipl.dto.ApiResponse;
import com.ipl.dto.OwnerReqDto;
import com.ipl.pojos.Owner;
import com.ipl.pojos.Teams;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerDao ownerDao;
	@Autowired
	private TeamDao teamDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse addOwner(OwnerReqDto ownerDto) {
		Teams team = teamDao.findById(ownerDto.getTeamId()).orElseThrow(() -> new RuntimeException("Invalid Team Id"));
		System.out.println(team);

		Owner owner = modelMapper.map(ownerDto, Owner.class);
		owner.setMyteam(team);
		Owner save = ownerDao.save(owner);

		return new ApiResponse("Owner Added SuccessFully");
	}
}
