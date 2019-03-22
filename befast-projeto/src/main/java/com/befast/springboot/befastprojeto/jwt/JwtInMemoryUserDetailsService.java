package com.befast.springboot.befastprojeto.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.befast.springboot.befastprojeto.admin.usuario.Usuario;
import com.befast.springboot.befastprojeto.admin.usuario.UsuarioController;
import com.befast.springboot.befastprojeto.admin.usuario.UsuarioService;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {
		
	@Autowired
	private UsuarioController userController;
	
	@Autowired
	private UsuarioService userService;
	
	List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
	
	private String senhaDigitada = "";

//	static {
//		inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
//				"$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
//		inMemoryUserList.add(new JwtUserDetails(2L, "ranga",
//				"$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm", "ROLE_USER_2"));
//		inMemoryUserList.add(new JwtUserDetails(3L, "andre",
//				"$2a$10$hJw8NHDuFedhCzlLe6VIWeJglsP3hLpXDfgoWuoYSoA/M/wG78ARO", "ROLE_USER_3"));
//		
//		//$2a$10$hJw8NHDuFedhCzlLe6VIWeJglsP3hLpXDfgoWuoYSoA/M/wG78ARO
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		Usuario usuario = null;
		List<Usuario> users = userController.getAllUsers(username);		
		if (users != null && !users.isEmpty()) {
			usuario = users.get(0);			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedString = userService.gerarCriptografia(usuario.getPassword());						
			encodedString = encoder.encode(encodedString);	
			
			inMemoryUserList.add(new JwtUserDetails(usuario.getId(), usuario.getUsername(),
					encodedString, usuario.getRole().getNome(), usuario.getSaldo()));
		}		
		
				
		
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}
		
}