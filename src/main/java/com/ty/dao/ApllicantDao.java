package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.text.AbstractDocument.BranchElement;

import com.ty.dto.Applicant;
import com.ty.dto.Branch;

public class ApllicantDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = null;

	public Applicant saveApplicant(Applicant applicant) {
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(applicant);
		entityTransaction.commit();
		return applicant;
	}
	
	public List<Applicant> getAllApplicants(){
		String sql = "Select a from Applicant a";
		Query query = entityManager.createQuery(sql);
		List<Applicant> applicants = query.getResultList();
		if(applicants != null) {
			return applicants;
		}
		else
			return null;
	}

	public Applicant getApplicantById(int id) {
		Applicant applicant = entityManager.find(Applicant.class, id);
		if (applicant != null) {
			return applicant;
		} else {
			return null;
		}
	}

	public List<Applicant> getApplicantByBranchId(int branch_id) {
		Branch branch = entityManager.find(Branch.class, branch_id);
		if (branch != null) {
			List<Applicant> applicants = branch.getApplicants();
			return applicants;
		} else {
			return null;
		}

	}

	public Applicant updateApplicantById(Applicant applicant, int id) {
		Applicant applicant2 = entityManager.find(Applicant.class, id);
		if (applicant2 != null) {
			entityTransaction=entityManager.getTransaction();
			applicant.setId(id);
			entityTransaction.begin();
			entityManager.merge(applicant);
			entityTransaction.commit();
			return applicant;
		} else {
			return null;
		}
	}
	
	public List<Applicant> filterApplicantByPer(double percentage) {
		String sql = "Select a from Applicant a where a.puc>=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, percentage);
		List<Applicant> applicants = query.getResultList();
		if(applicants != null) {
			return applicants;
		}
		return null;
	}
}
