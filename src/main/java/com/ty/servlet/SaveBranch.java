package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.BranchDao;
import com.ty.dto.Branch;
import com.ty.service.BranchService;
@WebServlet(value = "/SaveBranch")
public class SaveBranch extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("branchname");
		
		Branch branch=new Branch();
		branch.setBranchName(name);
		
		BranchService branchService=new BranchService();
		Branch branch2=branchService.saveBranch(branch);
		if(branch2!=null) {
			req.setAttribute("branch", branch2);
			RequestDispatcher dispatcher=req.getRequestDispatcher("createbranch.jsp");
			dispatcher.forward(req, resp);
		}else {
			resp.sendRedirect("home.jsp");
		}
	}
	
	
	

}
