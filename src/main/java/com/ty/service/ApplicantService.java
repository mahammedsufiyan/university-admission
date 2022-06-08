package com.ty.service;

import java.util.List;

import com.ty.dao.ApllicantDao;
import com.ty.dto.Applicant;

public class ApplicantService {
	ApllicantDao apllicantDao = new ApllicantDao();

	public Applicant saveApplicant(Applicant applicant) {

		return apllicantDao.saveApplicant(applicant);
	}

	public List<Applicant> getAllApplicants(){
		return apllicantDao.getAllApplicants();
	}

	
	public Applicant getApplicantById(int id) {
		return apllicantDao.getApplicantById(id);
	}

	public List<Applicant> getApplicantByBranchId(int branch_id) {
		return apllicantDao.getApplicantByBranchId(branch_id);
	}

	public Applicant updateApplicantById(Applicant applicant, int id) {
		return apllicantDao.updateApplicantById(applicant, id);
	}
	
	public List<Applicant> filterApplicantByPer(double percentage) {
		return apllicantDao.filterApplicantByPer(percentage);
	}

}
