package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogs.service.UserService;

@Controller
public class LogoutController {
	@Autowired
	private UserService userService;

	@RequestMapping("/logout")
	public String renderLogout(Model map)
	{
		return "/login";
	}
}
