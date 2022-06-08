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

@WebServlet(value = "/getallbranchformac")
public class GetAllBranchForMac extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getParameter("");
		
		BranchService branchService=new BranchService();
		List<Branch> branchs=branchService.getAllBranch();
		if(branchs!=null) {
			req.setAttribute("allbranchformac", branchs);
			RequestDispatcher dispatcher=req.getRequestDispatcher("viewallbranchformac.jsp");
			dispatcher.forward(req, resp);
		}else {
			
		}
	}

}
