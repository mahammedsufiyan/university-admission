package com.ty.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Branch;
import com.ty.service.BranchService;

@WebServlet(value = "/getallbranch")
public class GetAllBranch extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getParameter("");
		
		BranchService branchService=new BranchService();
		List<Branch> branchs=branchService.getAllBranch();
		if(branchs!=null) {
			req.setAttribute("allbranch", branchs);
			RequestDispatcher dispatcher=req.getRequestDispatcher("viewallbranch.jsp");
			dispatcher.forward(req, resp);
		}else {
			
		}
	}

}
