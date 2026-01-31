package com.dao;

import java.util.List;

import com.entity.User;
import com.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class UserDao {
	public void insert(User user) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(User user) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void deleteById(Long id) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityManager.remove(user);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
	}

	public List<User> fetchAll() {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		List<User> user = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
		entityManager.close();
		return user;
	}
	
	public User fetchById(Long id) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		User user = entityManager.find(User.class, id);
		entityManager.close();
		return user;
	}
}
