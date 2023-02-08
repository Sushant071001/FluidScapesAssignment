package com.spring.boot.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.entity.User;
import com.spring.boot.repository.UserRepo;
import com.spring.boot.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	// For getting all users data from database
	public List<User> getAllUsers(User user) {
		return userRepo.findAll();
	}

	@Override
	// For adding user in database
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	// For getting user by provided id
	public User getUserById(long id) {
		return userRepo.findById(id).get();
	}

	@Override
	// For updating user by provided id	
	public User updateUser(User user, long id) {

		Optional<User> findById = userRepo.findById(id);

		User user2 = new User();
		if (findById.isPresent()) {
			user2.setId(user.getId());
			user2.setName(user.getName());
			user2.setAddress(user.getAddress());
			user2.setContact(user.getContact());
		}

		return userRepo.save(user2);
	}

	@Override
	// For deleting user by provided id
	public void deleteById(long id) {
		userRepo.deleteById(id);
	}

}
