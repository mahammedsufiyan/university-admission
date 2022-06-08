package com.ty.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Applicant;
import com.ty.service.ApplicantService;
@WebServlet(value = "/getallapplicants")
public class GetAllApplicants extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ApplicantService applicantService = new ApplicantService();
		List<Applicant> applicants= applicantService.getAllApplicants();
		if(applicants != null) {
			req.setAttribute("allapplicants", applicants);
			RequestDispatcher dispatcher = req.getRequestDispatcher("viweallapplicants.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
