package com.befast.springboot.befastprojeto.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository userRepository;
		
	public List<Usuario> getAllUsers(String username) {
		return userRepository.findByUsername(username);		
	}
	
	public Usuario getUser(String username, long id) {
		return userRepository.findById(id).get();		
	}
	
	public void deleteUser(String username, long id) {

		userRepository.deleteById(id);
		
	}
		
	public Usuario updateUser(String username, long id, Usuario user) {

		Usuario userUpdated = userRepository.save(user);

		return userUpdated;
	}
	
	public void createUser( String username, Usuario user) {		
		user.setUsername(username);
		Usuario createdTodo = userRepository.save(user);
		
	}

}
