package com.sam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sam.daos.CandidateDao;
import com.sam.daos.CandidateDaoImpl;
import com.sam.entities.Candidate;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
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
		List<Candidate> list = new ArrayList();

		try (CandidateDao candDao = new CandidateDaoImpl()) {
			list = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
//		out.println("<body>");
		ServletContext app2 = this.getServletContext();
		String appColor = app2.getInitParameter("app.color");

		out.printf("<body style=background-color:%s>", appColor);

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

		ServletContext ctx = this.getServletContext();
		String ann = (String) ctx.getAttribute("announcement");
		if (ann != null)
			out.println("<p style='color:red'> NOTE: " + ann + "</p>");

		out.println("<h2>Voting Result</h2>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");

		for (Candidate c : list) {
			out.println("<tr>");
			out.printf("<td>%d</td>\n", c.getId());
			out.printf("<td>%s</td>\n", c.getName());
			out.printf("<td>%s</td>\n", c.getParty());
			out.printf("<td>%d</td>\n", c.getVotes());

			out.println("<td>\n");
			out.printf("<a href='editcand?id=%d'><img src='images/edit.png' alt='Edit' width='24' height='24'></a>\n",
					c.getId());
			out.printf(
					"<a href='delcand?id=%d'><img src='images/delete.png' alt='Delete' width='24' height='24'></a>\n",
					c.getId());
			out.println("</td>\n");

			out.println("</tr>");
		}

		out.println("</tbody>");
		out.println("</table>");

		String message = (String) req.getAttribute("msg");
		if (message != null)
			out.println("<p>" + message + "</p>");
		out.println("<p><a href='newcandidate.html'>Add New Candidate</a></p>");
		out.println("<p><a href='index.html'>Sign Out</a></p>");
		out.println("<p><a href='announcement.html'>Announcement</a></p>");
		out.println("</body>");
		out.println("</html>");

	}
}
