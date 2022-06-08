package com.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Mac;

public class MacDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=null;
	public Mac saveMac( Mac  mac) {
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(mac);
		entityTransaction.commit();
		return mac;
	}

}
