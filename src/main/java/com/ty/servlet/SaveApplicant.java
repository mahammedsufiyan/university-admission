
package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Applicant;
import com.ty.dto.Branch;
import com.ty.service.ApplicantService;
import com.ty.service.BranchService;

@WebServlet(value = "/applicantRegistation")
public class SaveApplicant extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("BranchId"));

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		double puc = Double.parseDouble(req.getParameter("puc"));

		Applicant applicant = new Applicant();
		applicant.setName(name);
		applicant.setEmail(email);
		applicant.setPhone(phone);
		applicant.setAge(age);
		applicant.setGender(gender);
		applicant.setPuc(puc);
		BranchService branchService = new BranchService();
		Branch branch = branchService.getBranchById(id);
		applicant.setBranch(branch);
		

		ApplicantService applicantService = new ApplicantService();
		Applicant applicant2 = applicantService.saveApplicant(applicant);
		if (applicant2 != null) {
			req.setAttribute("apple", applicant2);
			RequestDispatcher dispatcher = req.getRequestDispatcher("view.jsp");
			dispatcher.forward(req, resp);
		} else {
			resp.sendRedirect("home.jsp");
		}

	}
}
