package com.ty.service;

import java.util.List;

import com.ty.dao.BranchDao;
import com.ty.dto.Branch;

public class BranchService {
	BranchDao branchDao = new BranchDao();

	public Branch saveBranch(Branch branch) {
		return branchDao.saveBranch(branch);
	}

	public Branch getBranchById(int id) {
		return branchDao.getBranchById(id);
	}

	public List<Branch> getAllBranch() {
		return branchDao.getAllBranch();
	}
}
