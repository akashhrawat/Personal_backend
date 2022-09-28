package com.TestProject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestProject.model.User;
import com.TestProject.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User addUser(User user) {
		return this.repo.save(user);
	}
	
	public List<User> getAllData() {
		return this.repo.findAll();
	}
	
	public Optional<User> userById(int Id) {
		return this.repo.findById(Id);
	}
	
	public void updateUserById(User user,int Id) {
		List<User> list=getAllData();
		list.stream().map((b)->{
			if(b.getId()==user.getId()) {
				b=user;
			}
			this.repo.save(b);
			return b;
		}).collect(Collectors.toList());
	}
	
	public void deleteUserById(int Id) {
		repo.deleteById(Id);
	}
	public void deleteAllUsers() {
	        repo.deleteAll();
	}
}
