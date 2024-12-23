package com.ipl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.dto.OwnerReqDto;
import com.ipl.service.OwnerService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/owners")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	@PostMapping
	public ResponseEntity<?> addOwner(@RequestBody OwnerReqDto ownerDto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.addOwner(ownerDto));
	}

}
