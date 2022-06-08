package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Applicant;
import com.ty.service.ApplicantService;
//@WebServlet(value = "/getapplicantbyid")
public class GetApplicantById extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		 
		 
		 ApplicantService applicantService=new ApplicantService();
		Applicant  applicant=applicantService.getApplicantById(id);
		if(applicant!=null) {
			req.setAttribute("applicant", applicant);
			RequestDispatcher dispatcher=req.getRequestDispatcher("view.jsp");
			dispatcher.forward(req, resp);
		}else {
			resp.sendRedirect("applicanthome.jsp");
		}
	}
}
