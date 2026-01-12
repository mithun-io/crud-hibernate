package com.controller;

import java.time.LocalDate;

import com.dao.EmployeeDao;
import com.entity.Employee;

public class EmployeeController {

	public static void main(String[] args) {

		EmployeeDao dao = new EmployeeDao();

		insertEmployees(dao);
		fetchAll(dao);
	}
	
	private static Employee create(String name, String job, long salary, LocalDate hiredate) {
		Employee e = new Employee();
		e.setEname(name);
		e.setJob(job);
		e.setSalary(salary);
		e.setHiredate(hiredate);
		return e;
	}
	
	private static void insertEmployees(EmployeeDao dao) {

		dao.insert(create("smith", "salesman", 800, LocalDate.of(2022, 1, 10)));
		dao.insert(create("allen", "salesman", 1200, LocalDate.of(2021, 5, 15)));
		dao.insert(create("wards", "clerk", 1400, LocalDate.of(2023, 3, 20)));
		dao.insert(create("martin", "manager", 2600, LocalDate.of(2020, 7, 5)));
		System.out.println("inserted successfully");
	}

	

	private static void fetchAll(EmployeeDao dao) {
		dao.fetchAll().forEach(e -> System.out.println(e.getId() + " " + e.getEname() + " " + e.getJob() + " " + e.getSalary() + " " + e.getHiredate()));
		System.out.println("fetched successfully");
	}

	private static void fetchById(EmployeeDao dao, int id) {
		Employee e = dao.fetchById(id);
		if (e != null) {
			System.out.println(e.getId() + " " + e.getEname() + " " + e.getJob() + " " + e.getSalary() + " " + e.getHiredate());
		} else {
			System.out.println(id + " not found");
		}
	}

	private static void updateEmployee(EmployeeDao dao, int id) {
		Employee e = dao.fetchById(id);
		if (e != null) {
			e.setJob("team lead" + e.getJob());
			e.setSalary(e.getSalary() + 500); 
			e.setHiredate(LocalDate.of(2020, 5, 31)); 
			dao.update(e);
			System.out.println(id + " updated successfully");
		}
	}

	private static void deleteEmployee(EmployeeDao dao, int id) {
		dao.deleteById(id);
		System.out.println(id + " deleted successfully");
	}
}