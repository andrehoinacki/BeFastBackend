package com.befast.springboot.befastprojeto.admin.usuario;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/admin/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/list")
	public UsuarioPageResponse getAll(@RequestBody UsuarioFilter filter) throws Exception{
		return usuarioService.list(filter);
	}
	
	@PostMapping("/novo")
	public Usuario updateTodo(@RequestBody Usuario usuario) throws Exception{
		return usuarioService.save(usuario);
	}
}