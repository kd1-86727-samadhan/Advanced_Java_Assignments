package com.sam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sam.daos.UserDao;
import com.sam.daos.UserDaoImpl;
import com.sam.entities.User;

@WebServlet("/adnewuser")
public class AddNewUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String firstName = req.getParameter("fName");
		String lastName = req.getParameter("lName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String birthDate = req.getParameter("date");

		Date dob = Date.valueOf(birthDate);

//		String status = req.getParameter("status");
//		String role = req.getParameter("role");

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Registration</title>");
		out.println("</head>");
		out.println("<body>");

		try (UserDao userDao = new UserDaoImpl()) {
			User u = new User(0, firstName, lastName, email, password, dob, 0, "voter");
			int count = userDao.save(u);
			if (count == 1)
				out.println("<h4>New user added successful</h4>");
			else
				out.println("<h4>New user registration failed.</h4>");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		out.println("</body>");
		out.println("<html>");
	}

}
