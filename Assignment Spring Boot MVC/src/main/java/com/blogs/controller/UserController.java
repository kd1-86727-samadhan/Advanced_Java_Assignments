package com.blogs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;
import com.blogs.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	// depcy
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in ctor " + getClass());
	}

	/*
	 * URL - http://host:port/ctx/users/signin method - POST resp - redirect view
	 * name --> home page
	 */
	@PostMapping("/signin")

	/*
	 * @RequestParam - method argument level annotation, to bind incoming request
	 * param to method argument (recommendation - match the names !)
	 * 
	 * @RequestParam String email SC => String email =
	 * request.getParameter("email")....
	 * 
	 * @RequestParam String password SC => String password =
	 * request.getParameter("password")....
	 */

	public String singInUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
		System.out.println("in sign in " + email + " " + password);

		try {
			// Invoke service layer method
			User user = userService.authenticateUser(email, password);
			// => valid login, save user details under session scope
			session.setAttribute("user_details", user);
			// continued to role based authorization
			if(user.getRole() == UserRole.ADMIN)
				return "redirect:/admin/home";
			if(user.getRole() == UserRole.BLOGGER)
				return "redirect:/blogger/home";
		} catch (RuntimeException e) // Post Redirect Get
		{
			System.out.println("Error in controller: " + e);

			/*
			 * In case of invalid login -> redirect the client to ogin page, highlighted
			 * with error message add a error message under session scope
			 */
			
			session.setAttribute("mesg", "Please retry, Invalid Email or Password");
			return "redirect:/";

			/*
			 * SC --> WC --> response.sendRedirect("/"); 
			 * SC = Spring Container 
			 * WC = Web Container
			 */
		}
		return "";
	}

}
