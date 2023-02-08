package com.spring.boot.services;

import java.util.List;

import com.spring.boot.entity.User;

public interface UserService {

	public List<User> getAllUsers(User user);

	public User addUser(User user);

	public User getUserById(long id);

	public void deleteById(long id);

	public User updateUser(User user, long id);

}
