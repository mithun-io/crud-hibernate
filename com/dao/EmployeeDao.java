
package com.dao;

import com.entity.Employee;
import com.util.JPAUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class EmployeeDao {

	public void insert(Employee emp) {
		EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
		manager.getTransaction().begin();
		manager.persist(emp);
		manager.getTransaction().commit();
		manager.close();
	}

	public Employee fetchById(int id) {
		EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
		Employee employee = manager.find(Employee.class, id);
		manager.close();
		return employee;
	}

	public List<Employee> fetchAll() {
		EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
		List<Employee> list = manager.createQuery("from Employee", Employee.class).getResultList();
		manager.close();
		return list;
	}

	public void update(Employee employee) {
		EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
		manager.getTransaction().begin();
		manager.merge(employee);
		manager.getTransaction().commit();
		manager.close();
	}

	public void deleteById(int id) {
		EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
		Employee employee = manager.find(Employee.class, id);
		if (employee != null) {
			manager.getTransaction().begin();
			manager.remove(employee);
			manager.getTransaction().commit();
		}
		manager.close();
	}
}
