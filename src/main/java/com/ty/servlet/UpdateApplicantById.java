package com.ty.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Applicant;
import com.ty.service.ApplicantService;

public class UpdateApplicantById extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		int age=Integer.parseInt(req.getParameter("age"));
		String gender=req.getParameter("gender");
		double puc=Double.parseDouble(req.getParameter("puc"));
		
		
		Applicant applicant=new Applicant();
		applicant.setName(name);
		applicant.setEmail(email);
		applicant.setPhone(phone);
		applicant.setAge(age);
		applicant.setGender(gender);
		applicant.setPuc(puc);
		
		ApplicantService applicantService=new ApplicantService();
		Applicant applicant2=applicantService.updateApplicantById(applicant, age);
		if(applicant2!=null) {
			
		}else {
			
		}
	}

}
