package com.TestProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TestProject.model.User;
import com.TestProject.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		 System.out.println(this.getClass().getSimpleName() + " - Register new User method is invoked.");
		return ResponseEntity.ok(userService.addUser(user));
	}
	
	@GetMapping("/userall")
	public List<User> getUsers() {
		return userService.getAllData();
	}
	
	 @GetMapping("/user/{id}")
	 public User getEmployeeById(@PathVariable int id) throws Exception {
	        System.out.println(this.getClass().getSimpleName() + " - Get User details by id is Called.");
	 
	        Optional<User> u =  userService.userById(id);
	        if(!u.isPresent())
	            throw new Exception("Could not find user with id- " + id);
	        return u.get();
	    }
	
	 @PutMapping("/updateuser/{id}")
	    public User updateUser(@RequestBody User user,@PathVariable("id") int Id){
	        this.userService.updateUserById(user,Id);
	        return user;
	    }
	 @DeleteMapping(value= "/user/delete/{id}")
	 public void deleteUserById(@PathVariable int id) throws Exception {
	        System.out.println(this.getClass().getSimpleName() + " - Delete User by id is Called.");
	 
	        Optional<User> emp =  userService.userById(id);
	        if(!emp.isPresent())
	            throw new Exception("Could not find user with id- " + id);
	 
	        userService.deleteUserById(id);
	    }
	 @DeleteMapping(value= "/user/deleteall")
	 public void deleteAll() {
	        System.out.println(this.getClass().getSimpleName() + " - Delete all users is called.");
	        userService.deleteAllUsers();
	    }
}
