package com.sam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

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

		Cookie c1 = new Cookie("uname", "");
		c1.setMaxAge(-1);
		resp.addCookie(c1);
		Cookie c2 = new Cookie("role", "");
		c2.setMaxAge(-1);
		resp.addCookie(c2);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Logout</title>");
		out.println("</head>");
		out.println("<body>");

		Cookie[] arr = req.getCookies();
		String userName = "", role = "";
		if (arr != null) {
			for (Cookie c : arr) {
				if (c.getName().equals("uname"))
					userName = c.getValue();
				if (c.getName().equals("role"))
					role = c.getValue();
			}
		}
		out.printf("Hello, %s (%s)<hr/>\n", userName, role);

		out.println("<h2>Thank you</h2>");
		out.println("<p>See you after 5 years.</p>");
		out.println("<p><a href='index.html'>Login Again</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
