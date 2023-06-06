package com.becoder.service;

import java.util.List;

import com.becoder.entites.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUser();

	User getUser(String userId);

	User updateUser(User user);

	void deleteUser(String userId);

}
