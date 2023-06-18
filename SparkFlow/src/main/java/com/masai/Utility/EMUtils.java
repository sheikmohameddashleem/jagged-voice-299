package com.masai.Utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtils {

	static EntityManagerFactory emf = null;
	static {
		emf = Persistence.createEntityManagerFactory("CRM");
	}

	public static EntityManager createConnection() {
		EntityManager em = emf.createEntityManager();
		return em;
	}

}
