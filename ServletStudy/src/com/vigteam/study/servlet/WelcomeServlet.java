package com.vigteam.study.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class WelcomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// 파라미터 받기
		String name = req.getParameter("name");
		if (name == null) {
			name = "?";
		}
		
		resp.setCharacterEncoding("UTF-8");
//		PrintWriter writer = resp.getWriter();
//		writer.println("<h1>Welcome, " + name + "</h1>");
		req.setAttribute("name" , name);
		RequestDispatcher rd = 
				req.getRequestDispatcher("/WEB-INF/views/home.jsp");
		rd.forward(req, resp);
		
	}

}
