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
import com.ty.dto.Branch;
import com.ty.service.ApplicantService;
@WebServlet(value = "/getapplicantbyid")
public class GetApplicantByBranchId extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		int branch_id=Integer.parseInt(req.getParameter("branch_id"));
		
		Branch branch = (Branch) req.getAttribute("branchById");
		int branch_id = branch.getId();
		
		
		ApplicantService applicantService=new ApplicantService();
		List<Applicant> listofapplicant=applicantService.getApplicantByBranchId(branch_id);
		
		if(listofapplicant!=null) {
			req.setAttribute("applicant", listofapplicant);
			RequestDispatcher dispatcher = req.getRequestDispatcher("viweapplicantsbyid.jsp");
			dispatcher.forward(req, resp);
		}
		
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("getbyid");
			dispatcher.include(req, resp);		
					
		}
	}

}
