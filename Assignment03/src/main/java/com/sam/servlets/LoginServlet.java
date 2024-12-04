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

import com.sam.daos.UserDao;
import com.sam.daos.UserDaoImpl;
import com.sam.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
		// get email and password from login

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		// Validate login against db records

		try (UserDao userDao = new UserDaoImpl()) {
			User dbUser = userDao.findByEmail(email);

			if (dbUser != null && dbUser.getPassword().equals(password)) {
				
				Cookie c1 = new Cookie("uname", dbUser.getFirstName());
				c1.setMaxAge(3600);
				resp.addCookie(c1);
				Cookie c2 = new Cookie("role", dbUser.getRole());
				c2.setMaxAge(3600);
				resp.addCookie(c2);
				
				HttpSession session = req.getSession();
				session.setAttribute("curUser", dbUser);
				
				if (dbUser.getRole().equals("admin"))
					resp.sendRedirect("result");
				else
					resp.sendRedirect("candList");
			}

			// If login is failed, show "Invalid Login"
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login</title>");
				out.println("</head>");
//				out.println("<body>");
				ServletContext app2 = this.getServletContext();
				String appColor = app2.getInitParameter("app.color");

				out.printf("<body style=background-color:%s>", appColor);
				out.println("<h2>Login Failed</h2>");
				out.println("<p>Sorry, Invalid email or password.</p>");
				out.println("<p><a href='index.html'>Login Again</a></p>");
				out.println("</body>");
				out.println("</html>");
			}

		} // userDao.close()
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
