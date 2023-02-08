package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.entity.User;
import com.spring.boot.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/welcome")
	public String welcome() {
		return "This is WELCOME page ! No authentication needed";
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getAllUsers(User user) {
		List<User> allUsers = userService.getAllUsers(user);
		return ResponseEntity.ok(allUsers);
	}

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable("id") long id) {
		return userService.getUserById(id);
	}

	@PutMapping("/updateUserById/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") long id) {
		return userService.updateUser(user, id);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable("id") long id) {
		userService.deleteById(id);
		return "User deleted successfully with id : "+id;
	}
}
