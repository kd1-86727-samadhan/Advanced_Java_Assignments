package com.sam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profileServlet")
public class ProfileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String qualification = req.getParameter("qualification");
		String college = req.getParameter("college");
		String date = req.getParameter("date");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Assigment01</title>");
		out.println("</head>");
		out.println("<body style='background-color: pink;'>");

		out.println("<h3>First Name:" + firstName + "</h3>");
		out.println("<h3>Last Name:" + lastName + "</h3>");
		out.println("<h3>Qualification:" + qualification + "</h3>");
		out.println("<h3>College:" + college + "</h3>");
		out.println("<h3>Date:" + date + "</h3>");
		out.println("</body>");
		out.println("</html>");
	}
}
