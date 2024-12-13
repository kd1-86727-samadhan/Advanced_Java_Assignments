package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogs.service.BloggerService;

@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@Autowired
	private BloggerService blogService;

	public BloggerController() {
		System.out.println("In BloggerController Constructor: " + getClass());
	}

	@GetMapping("/home")
	public String renderBlogPostDisplayPage(Model map) {
		System.out.println("In BlogPost display: " + map);

		map.addAttribute("blogpost_list", blogService.getAllPost());
		return "/blogger/home";
	}
}
