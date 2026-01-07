package com.dao;

import com.entity.Employee;
import com.util.JPAUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class EmployeeDao {

	public void insert(Employee emp) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		em.close();
	}

	public Employee fetchById(int id) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		Employee emp = em.find(Employee.class, id);
		em.close();
		return emp;
	}

	public List<Employee> fetchAll() {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		List<Employee> list = em.createQuery("from Employee", Employee.class).getResultList();
		em.close();
		return list;
	}

	public void update(Employee emp) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(emp);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteById(int id) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		Employee emp = em.find(Employee.class, id);
		if (emp != null) {
			em.getTransaction().begin();
			em.remove(emp);
			em.getTransaction().commit();
		}
		em.close();
	}
}
