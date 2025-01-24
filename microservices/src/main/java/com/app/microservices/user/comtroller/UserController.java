package com.app.microservices.user.comtroller;

import java.util.List;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservices.user.entity.User;
import com.app.microservices.user.service.UserDaoService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping
	public List<User> getUsers() {
		return userDaoService.getUsers();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id) {
		return userDaoService.findUser(id);
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userDaoService.saveUser(user);
	}
}
