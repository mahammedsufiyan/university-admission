package com.ty.service;

import com.ty.dao.AdministratorDao;
import com.ty.dto.Administrator;

public class AdministrationService {
	AdministratorDao administratorDao = new AdministratorDao();

	public Administrator saveAdministrator(Administrator administrator) {

		return administratorDao.saveAdministrator(administrator);
	}

}
