package com.himanshu.spring.mediaservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.himanshu.spring.exception.UserNotFoundException;
import com.himanshu.spring.mediaobject.User;

@Component
public class RestMediaService {

	static List<User> allUsers;

	static {
		allUsers = new ArrayList<>();
		allUsers.add(new User(1, "Himanshu", LocalDate.now().minusYears(30)));
		allUsers.add(new User(2, "Richa", LocalDate.now().minusYears(28)));
		allUsers.add(new User(3, "Nikhil", LocalDate.now().minusYears(22)));

	}

	public List<User> getAllUsers() {
		return allUsers;
	}

	public User getUser(int id) {

		User user = allUsers.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
		if (user == null) {
			throw new UserNotFoundException("User not found");
		}
		return user;
	}

	public void deleteUser(int id) {

		allUsers.removeIf(u -> u.getId() == id);

	}

	public void setAllUsers(List<User> allUsers) {
		RestMediaService.allUsers = allUsers;
	}

	public User save(User user) {
		allUsers.add(user);
		return user;
	}

}
