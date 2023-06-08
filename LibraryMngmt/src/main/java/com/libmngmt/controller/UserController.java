package com.libmngmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.libmngmt.model.User;
import com.libmngmt.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController
{
	
	@Autowired
	private UserService userservice;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user)
	{
		return userservice.createUser(user);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> read()
	{
		return userservice.getAllUsers();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User read(@PathVariable Long id)
	{
		return userservice.getUserById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		userservice.deleteUser(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public User update(@PathVariable Long id, @RequestBody User user) {
		return userservice.updateUser(user, id);
	}
}
