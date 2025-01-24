package com.app.microservices.user.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.app.microservices.user.entity.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	static {
		for (int i = 1; i <= 3; i++) {
			User user = new User();
			user.setId(i);
			user.setName("test " + i);
			user.setDob(LocalDate.now().minusYears(5 * i));
			users.add(user);
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public User findUser(int id) {
		return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
	}

	public User saveUser(User user) {
		users.add(user);
		return user;

	}
}
