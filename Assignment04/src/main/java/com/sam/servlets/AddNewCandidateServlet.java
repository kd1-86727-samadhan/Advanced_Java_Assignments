package com.sam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sam.daos.CandidateDao;
import com.sam.daos.CandidateDaoImpl;
import com.sam.entities.Candidate;

@WebServlet("/adnewcandidate")
public class AddNewCandidateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String party = req.getParameter("party");
		
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Registration</title>");
		out.println("</head>");
		out.println("<body>");
		
		try(CandidateDao candDao = new CandidateDaoImpl())
		{
			Candidate c = new Candidate(0, name, party, 0);
			int count = candDao.save(c);
			if (count == 1)
				out.println("<h4>New candidate added successful</h4>");
			else
				out.println("<h4>New candidate registration failed.</h4>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		out.println("</body>");
		out.println("<html>");
	}
	
	
}
