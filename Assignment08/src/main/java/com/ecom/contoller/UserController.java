package com.ecom.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.UserReqDto;
import com.ecom.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody UserReqDto userReqDto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(userReqDto));
	}
	
	@GetMapping
	public ResponseEntity<?> showProducts(@RequestParam Long userId)
	{
		return ResponseEntity.ok(userService.showAllProducts(userId));
		
	}
	
}
