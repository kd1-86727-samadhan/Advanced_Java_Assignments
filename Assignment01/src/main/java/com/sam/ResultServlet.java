package com.sam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResultSet")
public class ResultServlet extends HttpServlet {
	private ArrayList<Marks> result;

	@Override
	public void init() throws ServletException {
		super.init();
		result = new ArrayList<Marks>();
		result.add(new Marks("Java Programming", 80.0));
		result.add(new Marks("Web Programming", 85.0));
		result.add(new Marks("Database Technology", 83.0));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Subject</th>");
		out.println("<th>Marks</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");

		for (Marks m : result) {
			out.println("<tr>");
			out.println("<td>" + m.getSubject() + "</td>");
			out.println("<td>" + m.getMarks() + "</td>");
			out.println("</tr>");
		}

		out.println("</tbody>"); 
		out.println("</table>"); 

	}
}
