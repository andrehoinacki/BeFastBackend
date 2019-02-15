package com.befast.springboot.befastprojeto.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
		
	public List<User> getAllUsers(String username) {
		return userRepository.findByUsername(username);		
	}
	
	public User getUser(String username, long id) {
		return userRepository.findById(id).get();		
	}
	
	public void deleteUser(String username, long id) {

		userRepository.deleteById(id);
		
	}
		
	public User updateUser(String username, long id, User user) {

		User userUpdated = userRepository.save(user);

		return userUpdated;
	}
	
	public void createUser( String username, User user) {		
		user.setUsername(username);
		User createdTodo = userRepository.save(user);
		
	}

}
