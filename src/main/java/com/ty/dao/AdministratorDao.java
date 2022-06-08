package com.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Administrator;

public class AdministratorDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = null;

	public Administrator saveAdministrator(Administrator administrator) {
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(administrator);
		entityTransaction.commit();
		return administrator;
	}

}
