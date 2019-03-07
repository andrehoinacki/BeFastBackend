package com.befast.springboot.befastprojeto.admin.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Usuario createUsuario(@RequestBody Usuario usuario) throws Exception{
		return usuarioService.save(usuario);
	}

	@GetMapping("/{id}")
	public Usuario getUsuario(@PathVariable long id){
		return usuarioService.findById(id);
	}

	@GetMapping("/bymatricula/{matricula}")
	public Usuario getUsuarioByMatricula(@PathVariable String matricula){
		return usuarioService.findByMatricula(matricula);
	}

	@PutMapping("/edit")
	public Usuario updateUsuario(@RequestBody Usuario usuario) throws Exception{
		return usuarioService.save(usuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id){
		
		usuarioService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}