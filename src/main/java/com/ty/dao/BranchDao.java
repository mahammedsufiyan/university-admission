package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Branch;

public class BranchDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = null;

	public Branch saveBranch(Branch branch) {
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
		return branch;
	}

	public Branch getBranchById(int id) {
		Branch branch = entityManager.find(Branch.class, id);
		if (branch != null) {
			return branch;
		} else {
			return null;
		}

	}

	public List<Branch> getAllBranch() {
		String sql = "select y from Branch y";
		Query query = entityManager.createQuery(sql);
		List<Branch> branchs = query.getResultList();
		if (branchs != null) {
			return branchs;
		} else {
			return null;
		}

	}

}
