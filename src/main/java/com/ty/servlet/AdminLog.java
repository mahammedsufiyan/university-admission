package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value = "/adminlogin")
public class AdminLog extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("psw");
		
		if(email.equals("admin@gmail.com") && password.equals("123")) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("mypass", email);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("adminhome.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("loginforadmin.jsp");
			dispatcher.include(req, resp);
		}
	}
}
