package com.controller;

import java.util.List;

import com.dao.UserDao;
import com.entity.User;

public class UserController {

	private final UserDao userDao = new UserDao();

	public User create(String name, String email, String password) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		return user;
	}

	public void addUsers(String name, String email, String password) {
		userDao.insert(create(name, email, password));
		System.out.println("inserted successfully");
	}

	public List<User> fetchUsers() {
		List<User> users = userDao.fetchAll();
		users.forEach(System.out::println);
		return users;
	}

	public User fetchUserById(Long id) {
		User user = userDao.fetchById(id);
		if (user != null) {
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			System.out.println(user.getCreatedAt());
		} else {
			System.out.println("user not found");
		}
		return user;
	}

	public void updateUser(Long id, String name, String email, String password) {
		User user = userDao.fetchById(id);
		if (user == null) {
			System.out.println("user not found");
			return;
		}

		if (name != null) {
			user.setName(name);
		}

		if (email != null) {
			user.setEmail(email);
		}

		if (password != null) {
			user.setPassword(password);
		}
		
		userDao.update(user);
		System.out.println("updated successfully");
	}

	public void deleteUser(Long id) {
		User user = userDao.fetchById(id);
		if (user != null) {
			userDao.deleteById(id);
		} else {
			System.out.println("user not found");
		}
		System.out.println("deleted successfully");
	}

	public static void main(String[] args) {
		UserController userController = new UserController();
		userController.deleteUser(1l);
	}
}
