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
@WebServlet(value = "/filterbyper")
public class FilterById extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		double percentage = Double.parseDouble(req.getParameter("per"));
		
		
		ApplicantService applicantService = new ApplicantService();
		List<Applicant> applicants = applicantService.filterApplicantByPer(percentage);
		
		if(applicants != null) {
			req.setAttribute("filterapplicants", applicants);
			RequestDispatcher dispatcher = req.getRequestDispatcher("displayfilteredapplicants.jsp");
			dispatcher.forward(req, resp);
			
		}
		else
		{
			resp.sendRedirect("givepertofilter.jsp");
		}
		
		
		
	}
}
