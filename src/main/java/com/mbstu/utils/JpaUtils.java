package com.mbstu.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	public static final String PERSISTANCE_UNIT = "persistance-unit";

	private static final EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT);
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}
}
