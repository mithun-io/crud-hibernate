package com.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");

	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
}
