package com.befast.springboot.befastprojeto.admin.saldo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.befast.springboot.befastprojeto.admin.role.Role;
import com.befast.springboot.befastprojeto.admin.role.RoleService;
import com.befast.springboot.befastprojeto.admin.usuario.Usuario;
import com.befast.springboot.befastprojeto.admin.usuario.UsuarioFilter;
import com.befast.springboot.befastprojeto.admin.usuario.UsuarioService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/venda/boleto")
public class AtualizarRetornoResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AtualizarRetornoController retornoController ;
	
	private RoleService roleService;
	
	@GetMapping("/retorno")
	public void atualizar() throws Exception {		
		List<Usuario> usuarios = usuarioService.findByStatusSaldo();
		retornoController.atualizarRetorno(usuarios);
	}
}