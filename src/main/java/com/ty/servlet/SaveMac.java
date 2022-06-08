package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Administrator;
import com.ty.dto.Mac;
import com.ty.service.MacService;
@WebServlet(value = "/maclogin1")
public class SaveMac extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));

		Mac mac = new Mac();
		mac.setName(name);
		mac.setEmail(email);
		mac.setPassword(password);
		mac.setGender(gender);
		mac.setAge(age);
		
		MacService macService=new MacService();
		Mac mac2=macService.saveMac(mac);
		if(mac2!=null) {
			req.setAttribute("maclogin", mac2);
			RequestDispatcher dispatcher=req.getRequestDispatcher("machomepage.jsp");
			dispatcher.forward(req, resp);
		}else {
			resp.sendRedirect("loginformformac.jsp");
		}

	}

}
