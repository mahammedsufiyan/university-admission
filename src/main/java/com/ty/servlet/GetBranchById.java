package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dto.Branch;
import com.ty.service.BranchService;
@WebServlet(value = "/getbyid")
public class GetBranchById extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		BranchService branchService=new BranchService();
		Branch branch=branchService.getBranchById(id);
		if(branch!=null) {
			
			req.setAttribute("branchById", branch);
			
			HttpSession httpSession = req.getSession();
			httpSession.getAttribute("mypass");
			RequestDispatcher dispatcher = req.getRequestDispatcher("getapplicantbyid");
			dispatcher.forward(req, resp);
			
			
		}else {
			
		}
	}

}
