package com.controller;

import java.time.LocalDate;

import com.dao.EmployeeDao;
import com.entity.Employee;

public class EmployeeController {

	public static void main(String[] args) {

		EmployeeDao dao = new EmployeeDao();

		insertEmployees(dao);

		fetchAll(dao);
		fetchById(dao, 1);

		updateEmployee(dao, 2);

		deleteEmployee(dao, 3);
		
		fetchAll(dao);
	}

	private static void insertEmployees(EmployeeDao dao) {

		dao.insert(create("SMITH", "SALESMAN", 800, LocalDate.of(2022, 1, 10)));
		dao.insert(create("ALLEN", "SALESMAN", 1200, LocalDate.of(2021, 5, 15)));
		dao.insert(create("WARDS", "CLERK", 1400, LocalDate.of(2023, 3, 20)));
		dao.insert(create("MARTIN", "MANAGER", 2600, LocalDate.of(2020, 7, 5)));

		System.out.println("EMPLOYEES INSERTED");
	}

	private static Employee create(String name, String job, long salary, LocalDate hiredate) {
		Employee e = new Employee();
		e.setEname(name);
		e.setJob(job);
		e.setSalary(salary);
		e.setHiredate(hiredate);
		return e;
	}

	private static void fetchAll(EmployeeDao dao) {
		System.out.println("ALL EMPLOYEES:");
		dao.fetchAll().forEach(e -> System.out.println(
				e.getId() + " " + e.getEname() + " " + e.getJob() + " " + e.getSalary() + " " + e.getHiredate()));
	}

	private static void fetchById(EmployeeDao dao, int id) {
		System.out.println("\nFETCH BY ID:");
		Employee e = dao.fetchById(id);
		if (e != null) {
			System.out.println(
					e.getId() + " " + e.getEname() + " " + e.getJob() + " " + e.getSalary() + " " + e.getHiredate());
		} else {
			System.out.println("NOT FOUND");
		}
	}

	private static void updateEmployee(EmployeeDao dao, int id) {
		Employee e = dao.fetchById(id);
		if (e != null) {
			e.setJob("TEAM LEAD " + e.getJob());
			e.setSalary(e.getSalary() + 500);
			// e.setHiredate(LocalDate.now()); 
			e.setHiredate(LocalDate.of(2020, 5, 31)); 
			dao.update(e);
			System.out.println("\nEMPLOYEE UPDATED");
		}
	}

	private static void deleteEmployee(EmployeeDao dao, int id) {
		dao.deleteById(id);
		System.out.println("\nEMPLOYEE DELETED");
	}
}
