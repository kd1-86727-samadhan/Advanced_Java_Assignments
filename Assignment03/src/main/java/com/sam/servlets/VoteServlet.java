package com.sam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sam.daos.CandidateDao;
import com.sam.daos.CandidateDaoImpl;
import com.sam.daos.UserDao;
import com.sam.daos.UserDaoImpl;
import com.sam.entities.User;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

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

		String candId = req.getParameter("candidate");
		int id = Integer.parseInt(candId);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		
		
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

		out.printf("Hello, %s (%s) <hr/>\n", userName, role);
		out.println("<h2>Voting Status</h2>");

//		HttpSession session = req.getSession();
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			resp.sendRedirect("index.html");
			resp.sendError(440);
			return;
		}
		User user = (User) session.getAttribute("curUser");

		if (user.getStatus() == 0) {
			try (CandidateDao candDao = new CandidateDaoImpl()) {
				int count = candDao.incrementVote(id);
				if (count == 1)
				{
					out.println("<h4>You have successfully casted your vote.</h4>");
					user.setStatus(1);
					try(UserDao userDao = new UserDaoImpl())
					{
						count = userDao.update(user);
						if(count == 1)	
							out.println("<h4>You are marked as voted.</h4>");
					}
				}else
					out.println("<h4>Your voting failed</h4>");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else {
			out.println("<h4>You have already voted.</h4>");
		}

		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("</body>");
		out.println("</html>");
	}

}
