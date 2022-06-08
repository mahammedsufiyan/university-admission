package com.ty.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Administrator;
import com.ty.service.AdministrationService;

public class SaveAdministrator extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		int age=Integer.parseInt(req.getParameter("age"));
		
		Administrator administrator=new Administrator();
		administrator.setName(name);
		administrator.setEmail(email);
		administrator.setPassword(password);
		administrator.setGender(gender);
		administrator.setAge(age);
		
		AdministrationService administrationService=new AdministrationService();
		Administrator administrator2=administrationService.saveAdministrator(administrator);
		if(administrator2!=null) {
			
		}else {
			resp.sendRedirect("");
		}
		
	}

}
